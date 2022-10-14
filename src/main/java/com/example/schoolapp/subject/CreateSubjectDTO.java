package com.example.schoolapp.subject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectDTO {
    private Integer id;
    private String name;
    private Integer hourPerWeek;
    private Integer credit;

}
