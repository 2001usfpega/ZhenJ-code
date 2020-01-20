package com.revature.Driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQ15 {

	@Test
	void test() {
		Q15 test = new Q15();
		double a = 12;
		double b = 3;

		
		double expecteds1 = 15;
		double expecteds2 = 9;
		double expecteds3 = 36;
		double expecteds4 = 4;
		
		System.out.println("haha");
		
		assertEquals(expecteds1,  test.addition(a, b));
		assertEquals(expecteds2,  test.subtraction(a, b));
		assertEquals(expecteds3,  test.multiplication(a, b));
		assertEquals(expecteds4,  test.division(a, b));
		

	}

}
