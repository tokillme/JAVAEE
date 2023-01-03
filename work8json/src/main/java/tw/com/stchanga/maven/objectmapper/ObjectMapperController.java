package tw.com.stchanga.maven.objectmapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ObjectMapperController {
	
	@GetMapping("/convert")
	public String convert() throws JsonProcessingException {
		User user=new User();
		user.setId(1);
		user.setName("Judy");
		
		ObjectMapper objectMapper=new ObjectMapper();
		//User --> json字串
		String jsonResult=objectMapper.writeValueAsString(user);
		System.out.println("Json的值為: "+jsonResult);
		
		
		//json字串 --> User
		String json="{\"id\":3,\"name\":\"stchanga\"}";
		User userResult=objectMapper.readValue(json, User.class);
		System.out.println("User 的 ID值為: "+userResult.getId());
		System.out.println("User 的 NAME值為: "+userResult.getName());
		
		
		return "convert success";
	}
}
