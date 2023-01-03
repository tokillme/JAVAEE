package tw.com.stchanga.maven.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateController {
	
	@GetMapping("/getForObject")
	public String getForObject() {
		
		RestTemplate restTemplate=new RestTemplate();
		
		Student student=restTemplate.getForObject(
				"https://mocki.io/v1/ad9eab51-3f27-4edb-aa18-3e30ee02e42c",
				Student.class);
		
		System.out.println("Student的id值為:"+student.getId());
		System.out.println("Student的name值為:"+student.getName());
		System.out.println("Student的name值為:"+student.getContactPhone());
		
		return "getForObject success";
		
	}

}
