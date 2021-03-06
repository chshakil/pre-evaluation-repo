package com.example.pre.evaluation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name = "reg_id")
	private String regId;

	@Column(name = "institution_id")
	private String institutionId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "reg_date")
	private String regDate;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "nid")
	private Long nid;

	@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "student")
	private List<AcademicQual> academicQualList;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "student_id", referencedColumnName = "id")
	@Transient
	private Address address;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "home_contact")
	private String homeContact;

	@Column(name = "std_contact")
	private String stdContact;

	@Column(name = "photo")
	private String photo;

	@Column(name = "created_on")
	private String createdOn;

	@Column(name = "created_by")
	private String createdBy;

	public Student() {

	}

	public Student(String regId, String institutionId, String firstName, String lastName, String email, String regDate,
			String dateOfBirth, int age, String gender, Long nid, String occupation, String homeContact,
			String stdContact, String photo, String createdOn, String createdBy) {
		this.regId = regId;
		this.institutionId = institutionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.regDate = regDate;
		this.dateOfBirth = dateOfBirth;
		this.age = age;
		this.gender = gender;
		this.nid = nid;
		this.occupation = occupation;
		this.homeContact = homeContact;
		this.stdContact = stdContact;
		this.photo = photo;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<AcademicQual> getAcademicQualList() {
		return academicQualList;
	}

	public void setAcademicQualList(List<AcademicQual> academicQualList) {
		this.academicQualList = academicQualList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getNid() {
		return nid;
	}

	public void setNid(Long nid) {
		this.nid = nid;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getHomeContact() {
		return homeContact;
	}

	public void setHomeContact(String homeContact) {
		this.homeContact = homeContact;
	}

	public String getStdContact() {
		return stdContact;
	}

	public void setStdContact(String stdContact) {
		this.stdContact = stdContact;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
