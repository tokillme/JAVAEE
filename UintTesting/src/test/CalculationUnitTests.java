package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import prod.CalculationTest;


class CalculationUnitTests {

	@Test
	void testAdd() {
		
		CalculationTest cal=new CalculationTest();
		int actual=cal.add(1, 2);
		assertEquals(3, actual);
	}

	@Test
	void testSub() {
		CalculationTest cal=new CalculationTest();
		int actual=cal.sub(3, 2);
		assertEquals(1, actual);
	}

}
