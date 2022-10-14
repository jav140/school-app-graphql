package com.example.schoolapp;

import com.example.schoolapp.author.Student;
import com.example.schoolapp.author.StudentRepository;
import com.example.schoolapp.subject.Subject;
import com.example.schoolapp.subject.SubjectRepository;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SchoolAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolAppApplication.class, args);
    }

@Component
class Init implements ApplicationContextAware{

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            StudentRepository studentRepository = applicationContext.getBean(StudentRepository.class);
            SubjectRepository subjectRepository = applicationContext.getBean(SubjectRepository.class);

            studentRepository.deleteAll();
            subjectRepository.deleteAll();

            Student john = new Student(1, "John", 20);
            Student mark = new Student(2, "Mark", 21);
            Student watson = new Student(3, "Watson", 22);

            studentRepository.saveAll(Arrays.asList(john,mark,watson));

            Subject machine_learning = new Subject(1, "Machine Learning", 6, 10, john);
            Subject cyber_security = new Subject(2, "Cyber Security", 8, 10, mark);
            Subject data_structure_and_algorithms = new Subject(3, "Data structure and algorithms", 6, 10, john);

            subjectRepository.saveAll(Arrays.asList(machine_learning,cyber_security,data_structure_and_algorithms));




        }
    }

}
