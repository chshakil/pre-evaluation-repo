package com.example.pre.evaluation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pre.evaluation.model.AcademicQual;

public interface AcademicRepository extends JpaRepository<AcademicQual, Integer> {

	List<AcademicQual> findByStudentId(int id);

	List<AcademicQual> findAllByStudentId(int id);


}
