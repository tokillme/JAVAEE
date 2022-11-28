package tw.com.pcschool.maven.dao;

import java.util.List;

import tw.com.pcschool.maven.Student;

public interface StudentDao {
	

	Student getById(Integer studentId);
	String delById(Integer studentId);
	String getByList(List<Student> studentList);
	String getByStudent(Student student);
}
