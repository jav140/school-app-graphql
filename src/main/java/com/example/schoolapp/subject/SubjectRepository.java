package com.example.schoolapp.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
