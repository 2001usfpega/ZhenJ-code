package com.revature.Driver;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class TestQ3 {

	@Test
	void test() {
		Q3 test = new Q3();
		String expecteds = "edcba";
		String actuals = test.reverseString("abcde");
		
		assertEquals(expecteds, actuals);
		
	}


}
