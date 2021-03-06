package com.example.pre.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "academic")
public class AcademicQual {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "degree")
	private String degree;

	@Column(name = "institute")
	private String institute;

	@Column(name = "completion_year")
	private int completionYear;

	@Column(name = "grade")
	private double grade;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public AcademicQual() {

	}

	public AcademicQual(String degree, String institute, int completionYear, double grade) {
		this.degree = degree;
		this.institute = institute;
		this.completionYear = completionYear;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public int getCompletionYear() {
		return completionYear;
	}

	public void setCompletionYear(int completionYear) {
		this.completionYear = completionYear;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
