package tw.com.pcschool.maven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.com.pcschool.maven.Student;
import tw.com.pcschool.maven.dao.StudentDao;

@Component
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student getById(Integer studentId) {
		return studentDao.getById(studentId);
	}

	@Override
	public String delById(Integer studentId) {
		return studentDao.delById(studentId);
	}

	@Override
	public String getByList(List<Student> studentList) {
		
		return studentDao.getByList(studentList);
	}

	@Override
	public String getByStudent(Student student) {
		
		return studentDao.getByStudent(student);
	}

}
