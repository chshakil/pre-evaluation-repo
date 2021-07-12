package com.example.pre.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "pre_street")
	private String preStreet;

	@Column(name = "pre_post_office")
	private String prePostOffice;

	@Column(name = "pre_upazila")
	private String preUpazila;

	@Column(name = "pre_district")
	private String preDistrict;

	@Column(name = "pre_division")
	private String preDivision;

	@Column(name = "per_street")
	private String perStreet;

	@Column(name = "per_post_office")
	private String perPostOffice;

	@Column(name = "per_upazila")
	private String perUpazila;

	@Column(name = "per_district")
	private String perDistrict;

	@Column(name = "per_division")
	private String perDivision;

	@JsonIgnore
//	@OneToOne(cascade = {CascadeType.ALL})
//  @JoinColumn(name="student_id")

//	@OneToOne(mappedBy = "address")
//	private Student student;

	@Column(name = "student_id")
	private Integer studentId;

	public Address() {

	}

	public Address(String preStreet, String prePostOffice, String preUpazila, String preDistrict, String preDivision,
			String perStreet, String perPostOffice, String perUpazila, String perDistrict, String perDivision,
			Integer studentId) {
		this.preStreet = preStreet;
		this.prePostOffice = prePostOffice;
		this.preUpazila = preUpazila;
		this.preDistrict = preDistrict;
		this.preDivision = preDivision;
		this.perStreet = perStreet;
		this.perPostOffice = perPostOffice;
		this.perUpazila = perUpazila;
		this.perDistrict = perDistrict;
		this.perDivision = perDivision;
		this.studentId = studentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreStreet() {
		return preStreet;
	}

	public void setPreStreet(String preStreet) {
		this.preStreet = preStreet;
	}

	public String getPrePostOffice() {
		return prePostOffice;
	}

	public void setPrePostOffice(String prePostOffice) {
		this.prePostOffice = prePostOffice;
	}

	public String getPreUpazila() {
		return preUpazila;
	}

	public void setPreUpazila(String preUpazila) {
		this.preUpazila = preUpazila;
	}

	public String getPreDistrict() {
		return preDistrict;
	}

	public void setPreDistrict(String preDistrict) {
		this.preDistrict = preDistrict;
	}

	public String getPreDivision() {
		return preDivision;
	}

	public void setPreDivision(String preDivision) {
		this.preDivision = preDivision;
	}

	public String getPerStreet() {
		return perStreet;
	}

	public void setPerStreet(String perStreet) {
		this.perStreet = perStreet;
	}

	public String getPerPostOffice() {
		return perPostOffice;
	}

	public void setPerPostOffice(String perPostOffice) {
		this.perPostOffice = perPostOffice;
	}

	public String getPerUpazila() {
		return perUpazila;
	}

	public void setPerUpazila(String perUpazila) {
		this.perUpazila = perUpazila;
	}

	public String getPerDistrict() {
		return perDistrict;
	}

	public void setPerDistrict(String perDistrict) {
		this.perDistrict = perDistrict;
	}

	public String getPerDivision() {
		return perDivision;
	}

	public void setPerDivision(String perDivision) {
		this.perDivision = perDivision;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}
