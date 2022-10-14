package com.example.schoolapp.author;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;


    @QueryMapping
    public Student getOne(@Argument Integer id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @SchemaMapping(typeName = "Query", value = "allStudents")
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    @MutationMapping
    public Student updateStudent(@Argument UpdateStudentDTO dto){

        Student student = studentRepository.findById(dto.getId()).
                orElseThrow(() -> new RuntimeException("Student not found"));

        student.setAge(dto.getAge());
        student.setName(dto.getName());
        return studentRepository.save(student);
    }

    @MutationMapping
    public Student createStudent(@Argument CreateStudentDTO dto){
        Student student = Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .age(dto.getAge())
                .build();
        return studentRepository.save(student);
    }





}