package com.example.pre.evaluation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pre.evaluation.model.AcademicQual;
import com.example.pre.evaluation.repository.AcademicRepository;

@Service
public class AcademicService {

	@Autowired
	private AcademicRepository _academicRepository;

	public AcademicQual createAcademic(AcademicQual academic) {
		return _academicRepository.save(academic);
	}

	public List<AcademicQual> createAcademicList(List<AcademicQual> academicQualList) {
		return _academicRepository.saveAll(academicQualList);
	}

	public List<AcademicQual> getAcademicList() {
		return _academicRepository.findAll();
	}

	public AcademicQual getAcademicById(int id) {
		return _academicRepository.findById(id).orElse(null);
	}
	
//	public List<AcademicQual> getAcademicListBySudentId(int id) {
//		return _academicRepository.findByStudentId(id);
//	}
	
	public List<AcademicQual> getAcademicListBySudentId(int id) {
		return _academicRepository.findAllByStudentId(id);
	}
	
	public String deleteAcademicById(int id) {
		_academicRepository.deleteById(id);
		return "academic removed !!" + id;
	}
	
	public void deleteAllAcademicList() {
		_academicRepository.deleteAll();
	}

	public AcademicQual updateAcademic(AcademicQual academic) {
		AcademicQual existingAcademic = _academicRepository.findById(academic.getId()).orElse(null);
		existingAcademic.setDegree(academic.getDegree());
		existingAcademic.setInstitute(academic.getInstitute());
		existingAcademic.setCompletionYear(academic.getCompletionYear());
		existingAcademic.setGrade(academic.getGrade());
		existingAcademic.setStudent(academic.getStudent());
		return _academicRepository.save(existingAcademic);
	}
	
//	public List<AcademicQual> updateAcademicList(List<AcademicQual> academicQualsList) {
//		List<AcademicQual> academicQualList = new ArrayList<>();
//		for(AcademicQual academicQual : academicQualsList) {
//			AcademicQual academicQual2 = updateAcademic(academicQual);
//			if(null != academicQual2) {
//				academicQualList.add(academicQual2);
//			}
//		}
//		return academicQualList;
//	}
	public List<AcademicQual> updateAcademicList(List<AcademicQual> academicQualsList) {
		return _academicRepository.saveAll(academicQualsList);
	}
}
