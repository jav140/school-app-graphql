package com.example.schoolapp.author;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
