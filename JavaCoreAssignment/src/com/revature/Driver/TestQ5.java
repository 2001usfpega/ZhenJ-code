package com.revature.Driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQ5 {

	@Test
	void test() {
		Q5 q5 = new Q5();
		
		String expecteds = "abcde";
		String actuals = q5.substring("abcdefgh", 5);
		
		assertEquals(expecteds, actuals);
		
	}

}
