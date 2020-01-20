package com.revature.Driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQ4 {

	@Test
	void test() {
		Q4 test = new Q4();
		int expecteds = 24;
		
		int actuals = test.factorial(4);
		
		assertEquals(expecteds, actuals);
		
		
		
	}

}
