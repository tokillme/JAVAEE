package tw.com.pcschool.maven.service;

import java.util.List;

import tw.com.pcschool.maven.Student;

public interface StudentService {
	Student getById(Integer studentId);
	String delById(Integer studentId);
	String getByList(List<Student> studentList);
	String getByStudent(Student student);
}
