package com.example.schoolapp.subject;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubjectDTO {
    private Integer id;
    private String name;
    private Integer hourPerWeek;
    private Integer credit;
}
