package com.example.pre.evaluation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pre.evaluation.model.Student;
import com.example.pre.evaluation.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService _studentService;

	@PostMapping("/save-student")
	public Student saveStudent(@RequestBody Student student) {
		return _studentService.createStudent(student);
	}

	@PostMapping("/save-student-list")
	public List<Student> saveStudentList(@RequestBody List<Student> studentList) {
		return _studentService.createStudents(studentList);
	}

	@GetMapping("/get-student-list")
	public List<Student> getAllStudents() {
		return _studentService.getStudents();
	}

	@GetMapping("/get-student-by-id")
	public Student findStudentById(@RequestParam("id") int id) {
		return _studentService.getStudentById(id);
	}

	@DeleteMapping("/delete-student-by-id")
	public String deleteStudentById(@RequestParam("id") int id) {
		return _studentService.deleteStudentById(id);
	}

//	@DeleteMapping("/delete-student-by-id/{id}")
//	public String deleteStudentById(@PathVariable int id) {
//		return _studentService.deleteStudentById(id);
//	}

	@PutMapping("/update-student")
	public Student upateStudent(@RequestBody Student student) {
		return _studentService.updateStudent(student);
	}

	@DeleteMapping("/delete-all-student")
	public String deleteAll() {
		_studentService.deleteStudents();
		return "Successfully delete all entities";
	}
}
