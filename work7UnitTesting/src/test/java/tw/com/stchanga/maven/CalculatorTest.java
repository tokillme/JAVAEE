package tw.com.stchanga.maven;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	@Disabled
	@Test
	public void testAdd() {
		Calculator cal=new Calculator();
		int result = cal.add(1, 2);
		assertEquals(3, result);
	}
	
	@DisplayName("測試除法問題!")
	@Test
	public void divide() {
		Calculator cal=new Calculator();

		assertThrows(ArithmeticException.class, () -> {
			cal.divide(1, 0);
		});
	}
	
	
}
