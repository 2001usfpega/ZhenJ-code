package com.revature.Driver;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class TestQ6 {

	@Test
	void test() {
		
		Q6 test = new Q6();
		String actuals = test.evenOrNot(340);
		String expecteds = "even";
		
		assertEquals(actuals, expecteds);
		
		actuals = test.evenOrNot(341);
		
		
		expecteds = "odd";
		
		
		
		assertEquals(actuals, expecteds);
		
	}

}
