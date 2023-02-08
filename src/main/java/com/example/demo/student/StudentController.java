package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // allows this class to have restful endpoints
@RequestMapping(path = "/")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping(path = "/") // makes this method a restful endpoint at /
	public String getBanner() {
		return "Welcome to my springboot-postgres api; use /swagger-ui.html to view the endpoints in this project or /v3/api-docs";
	}
	@GetMapping(path = "/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping(path = "/students") // add a Student to the DB
	public void registerNewStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}

	@DeleteMapping(path = "/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}

	@PutMapping(path="/students/{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required=false) String name, @RequestParam(required=false) String email) {
		studentService.updateStudent(studentId, name, email);
	}
}
