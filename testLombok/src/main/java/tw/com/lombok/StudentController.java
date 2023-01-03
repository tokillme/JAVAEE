package tw.com.lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;


@RestController
public class StudentController {
	

	@GetMapping("/test")
	public Student test() {
		Student student=new Student();
		student.setId("1");
		student.setName("Judy");
		
		return student;
		
	}
}
