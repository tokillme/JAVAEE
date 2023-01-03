package tw.com.stchanga.maven;

import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/students")
	public String insert(@RequestBody Student student) {
		
		studentRepository.save(student);
		return "執行資料庫 Create 操作";
	}
	
	@PutMapping("/students/{studentId}")
	public String update(@PathVariable Integer studentId,
			@RequestBody Student student) {
		
		//常用方法邏輯
		Student s = studentRepository.findById(studentId).orElse(null);
		if(s != null) {
			s.setName(student.getName());
			studentRepository.save(s);
			return "執行資料庫Update操作";
		}else {
			return "update失敗，數據不存在!!";
		}
		
		
		//student.setId(studentId);//如果已經存在就修改，若沒有就新增
		//studentRepository.save(student);
		
		
		
	}
	
	@DeleteMapping("/students/{studentId}")
	public String delete(@PathVariable Integer studentId) {
		
		studentRepository.deleteById(studentId);
		return "執行資料庫Delete操作";
	}
	
	@GetMapping("/students/{studentId}")
	public Student read(@PathVariable Integer studentId) {
		
		
		Student student= studentRepository.findById(studentId).orElse(null);
		
		return student;
	}
}
