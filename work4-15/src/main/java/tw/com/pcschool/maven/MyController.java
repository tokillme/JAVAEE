package tw.com.pcschool.maven;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("執行TEST1 方法 ");
		return "Helloe test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		System.out.println("執行 TEST2 方法");
		return "HELLO test2";
	}
}
