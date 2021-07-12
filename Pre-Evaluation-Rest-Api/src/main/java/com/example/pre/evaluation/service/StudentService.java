package com.example.pre.evaluation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.pre.evaluation.model.AcademicQual;
import com.example.pre.evaluation.model.Address;
import com.example.pre.evaluation.model.Student;
import com.example.pre.evaluation.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository _studentRepository;

	@Autowired
	private AddressService _addressService;

	@Autowired
	private AcademicService _academicService;

	public Student createStudent(Student student) {
		Student studentResp = _studentRepository.save(student);

		List<AcademicQual> academicQualListResp = new ArrayList<>();
		Address addressResp = null;

		if (!ObjectUtils.isEmpty(studentResp)) {
			if (student.getAcademicQualList() != null) {

				List<AcademicQual> academicQualList = student.getAcademicQualList();
				academicQualList.forEach(f -> f.setStudent(studentResp));

				academicQualListResp = _academicService.createAcademicList(academicQualList);
			}

			if (!ObjectUtils.isEmpty(studentResp) && !ObjectUtils.isEmpty(student.getAddress())) {
				Address address = student.getAddress();

				address.setStudentId(studentResp.getId());

				addressResp = _addressService.createAddress(address);
			}

		}
		studentResp.setAcademicQualList(academicQualListResp);
		studentResp.setAddress(addressResp);

		return studentResp;
	}

	public List<Student> createStudents(List<Student> studentList) {
		return _studentRepository.saveAll(studentList);
	}

	public List<Student> getStudents() {
		return _studentRepository.findAll();
	}

	public Student getStudentById(int id) {
		Student student = _studentRepository.findById(id).orElse(null);
		if (null != student) {
			Address address = _addressService.getAddressBySudentId(student.getId());

			List<AcademicQual> academicQualList = _academicService.getAcademicListBySudentId(student.getId());

			student.setAddress(address);
			student.setAcademicQualList(academicQualList);

			return student;
		}

		return null;
	}

	public String deleteStudentById(int id) {
		_studentRepository.deleteById(id);
		return "student removed !!" + id;
	}

	public void deleteStudents() {
		_studentRepository.deleteAll();
	}

	public Student updateStudent(Student student) {
		List<AcademicQual> academicQualListResp = new ArrayList<>();
		Address addressResp = null;

		Student existingStudent = _studentRepository.findById(student.getId()).orElse(null);

		existingStudent.setRegId(student.getRegId());
		existingStudent.setInstitutionId(student.getInstitutionId());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setRegDate(student.getRegDate());
		existingStudent.setDateOfBirth(student.getDateOfBirth());
		existingStudent.setAge(student.getAge());
		existingStudent.setGender(student.getGender());
		existingStudent.setNid(student.getNid());
		existingStudent.setOccupation(student.getOccupation());
		existingStudent.setHomeContact(student.getHomeContact());
		existingStudent.setStdContact(student.getStdContact());

		Student studentResp = _studentRepository.save(existingStudent);

		if (!ObjectUtils.isEmpty(studentResp)) {
			if (student.getAcademicQualList() != null) {

				List<AcademicQual> academicQualList = student.getAcademicQualList();
				academicQualList.forEach(f -> f.setStudent(studentResp));

				academicQualListResp = _academicService.updateAcademicList(academicQualList);
			}

			if (!ObjectUtils.isEmpty(studentResp) && !ObjectUtils.isEmpty(student.getAddress())) {
				Address address = student.getAddress();
				address.setStudentId(studentResp.getId());

				addressResp = _addressService.updateAddress(address);
			}

			studentResp.setAddress(addressResp);
			studentResp.setAcademicQualList(academicQualListResp);

			return studentResp;

		}

		return null;

	}
}
