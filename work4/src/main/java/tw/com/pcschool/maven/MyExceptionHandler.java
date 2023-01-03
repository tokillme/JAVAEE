package tw.com.pcschool.maven;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handle(RuntimeException e){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("RuntimeException: "+e.getMessage()); //SERVICE_UNAVAILABLE=503
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handel(IllegalArgumentException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("IllegalArgumentException: "+e.getMessage()); //BAD_REQUEST=400
	}

}
