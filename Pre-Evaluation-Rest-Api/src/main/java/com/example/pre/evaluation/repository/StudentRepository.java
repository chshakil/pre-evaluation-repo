package com.example.pre.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pre.evaluation.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
