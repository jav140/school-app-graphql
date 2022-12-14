package com.example.schoolapp.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentDTO {
    private Integer id;
    private String name;
    private Integer age;
}
