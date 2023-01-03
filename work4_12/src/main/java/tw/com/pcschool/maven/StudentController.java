package tw.com.pcschool.maven;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class StudentController {
	
	@PostMapping("/students")
	public String create(@RequestBody Student student) {
		if (student.getId()==null) {
			throw new RuntimeException("id 不可為null !");
		}
		return "執行資料庫Create操作";
	}
	
	@GetMapping("/students/{id}")
	public String read(@PathVariable Integer id) {
		return "執行READ操作";
	}
	
	@PutMapping("/students/{id}")
	public String update(@PathVariable Integer id,
						@RequestBody Student student,
						@RequestHeader String info) {
		return "執行資料庫update操作";
		//put會放在requestBody，類似POST
	}
	
	@DeleteMapping("/students/{id}")
	public String delete(@PathVariable Integer id) {
		return "執行資料庫的Delete操作";
		//類似GET 放在URL
	}
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello world");
	}


}
