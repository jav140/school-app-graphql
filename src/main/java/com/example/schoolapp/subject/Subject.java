package com.example.schoolapp.subject;

import com.example.schoolapp.author.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subject {

    @Id
    private Integer id;
    private String name;
    private Integer hourPerWeek;
    private Integer credit;

    @ManyToOne(targetEntity = Student.class,fetch= FetchType.LAZY)
    private Student student;

}
