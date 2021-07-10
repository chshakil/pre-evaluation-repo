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
	private String pre_street;

	@Column(name = "pre_po")
	private String pre_po;

	@Column(name = "pre_upa")
	private String pre_upa;

	@Column(name = "pre_dist")
	private String pre_dist;

	@Column(name = "pre_div")
	private String pre_div;

	@Column(name = "per_street")
	private String per_street;

	@Column(name = "per_po")
	private String per_po;

	@Column(name = "per_upa")
	private String per_upa;

	@Column(name = "per_dist")
	private String per_dist;

	@Column(name = "per_div")
	private String per_div;

	@JsonIgnore
//	@OneToOne(cascade = {CascadeType.ALL})
//  @JoinColumn(name="student_id")

//	@OneToOne(mappedBy = "address")
//	private Student student;

	@Column(name = "student_id")
	private Integer student_id;

	public Address() {

	}

	public Address(String pre_street, String pre_po, String pre_upa, String pre_dist, String pre_div, String per_street,
			String per_po, String per_upa, String per_dist, String per_div, Integer student_id) {
		this.pre_street = pre_street;
		this.pre_po = pre_po;
		this.pre_upa = pre_upa;
		this.pre_dist = pre_dist;
		this.pre_div = pre_div;
		this.per_street = per_street;
		this.per_po = per_po;
		this.per_upa = per_upa;
		this.per_dist = per_dist;
		this.per_div = per_div;
		this.student_id = student_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPre_street() {
		return pre_street;
	}

	public void setPre_street(String pre_street) {
		this.pre_street = pre_street;
	}

	public String getPre_po() {
		return pre_po;
	}

	public void setPre_po(String pre_po) {
		this.pre_po = pre_po;
	}

	public String getPre_upa() {
		return pre_upa;
	}

	public void setPre_upa(String pre_upa) {
		this.pre_upa = pre_upa;
	}

	public String getPre_dist() {
		return pre_dist;
	}

	public void setPre_dist(String pre_dist) {
		this.pre_dist = pre_dist;
	}

	public String getPre_div() {
		return pre_div;
	}

	public void setPre_div(String pre_div) {
		this.pre_div = pre_div;
	}

	public String getPer_street() {
		return per_street;
	}

	public void setPer_street(String per_street) {
		this.per_street = per_street;
	}

	public String getPer_po() {
		return per_po;
	}

	public void setPer_po(String per_po) {
		this.per_po = per_po;
	}

	public String getPer_upa() {
		return per_upa;
	}

	public void setPer_upa(String per_upa) {
		this.per_upa = per_upa;
	}

	public String getPer_dist() {
		return per_dist;
	}

	public void setPer_dist(String per_dist) {
		this.per_dist = per_dist;
	}

	public String getPer_div() {
		return per_div;
	}

	public void setPer_div(String per_div) {
		this.per_div = per_div;
	}
}
