package tw.com.pcschool.maven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.com.pcschool.maven.Student;
import tw.com.pcschool.maven.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students/{studentId}")
	public Student select(@PathVariable Integer studentId) {
		return studentService.getById(studentId);
	}
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		return studentService.delById(studentId);
	}
	
	@PostMapping("/students/batch")
	public String insertList(@RequestBody List<Student> studentList) {
		return studentService.getByList(studentList);
	}
	
	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
		return studentService.getByStudent(student);
	}
}
