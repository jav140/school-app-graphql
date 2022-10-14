package com.example.schoolapp.subject;

import com.example.schoolapp.author.Student;
import com.example.schoolapp.author.UpdateStudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectRepository;

    @QueryMapping
    public Subject findOne(@Argument Integer id){

        return subjectRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Subject not found"));
    }

    @SchemaMapping(typeName = "Query", value = "allSubjects")
    public List<Subject> findAll(){
        return subjectRepository.findAll();

    }

    @MutationMapping
    public Subject updateSubject(@Argument UpdateSubjectDTO dto){

        Subject subject = subjectRepository.findById(dto.getId()).
                orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setName(dto.getName());
        subject.setCredit(dto.getCredit());
        subject.setHourPerWeek(dto.getHourPerWeek());

        return subjectRepository.save(subject);
    }

    @MutationMapping
    public Subject createSubject(@Argument CreateSubjectDTO dto){

        Subject subject = Subject.builder()
                .id(dto.getId())
                .credit(dto.getCredit())
                .hourPerWeek(dto.getHourPerWeek())
                .name(dto.getName())
                .build();

        return subjectRepository.save(subject);
    }



}
