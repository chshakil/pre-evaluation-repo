package com.example.pre.evaluation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pre.evaluation.model.AcademicQual;
import com.example.pre.evaluation.service.AcademicService;

@RestController
@RequestMapping("/api/academicqual")
public class AcademicController {

	@Autowired
	private AcademicService _academicService;

	@PostMapping("/save-academic")
	public AcademicQual saveAcademic(@RequestBody AcademicQual academic) {
		return _academicService.createAcademic(academic);
	}

	@PostMapping("/save-academic-list")
	public List<AcademicQual> saveAcademics(@RequestBody List<AcademicQual> academicQualList) {
		return _academicService.creAcademics(academicQualList);
	}

	@GetMapping("/get-academic-list")
	public List<AcademicQual> getAllAcademics() {
		return _academicService.getAcademicList();
	}

	@GetMapping("/get-academicBy-Id/{id}")
	public AcademicQual findAcademicById(@PathVariable int id) {
		return _academicService.getAcademicById(id);
	}

	@DeleteMapping("/delete-academicBy-id/{id}")
	public String deleteAcademicById(@PathVariable int id) {
		return _academicService.deleteAcademicById(id);
	}

	@PutMapping("/update-academic")
	public AcademicQual upateAcademic(@RequestBody AcademicQual academic) {
		return _academicService.updateAcademic(academic);
	}

	@DeleteMapping("/delete-all-academicqual")
	public String deleteAll() {
		_academicService.deleteAllAcademicList();
		return "Successfully delete all entities";
	}
}
