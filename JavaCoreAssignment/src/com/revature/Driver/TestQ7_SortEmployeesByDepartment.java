package com.revature.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class TestQ7_SortEmployeesByDepartment {

	@Test
	void test() {
		
		String expectedsStr = "";
		String actualsStr = "";
		
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("ghi", "DDD" , 1));
		employees.add(new Employee("def", "BBB" , 3));
		employees.add(new Employee("abc", "AAA" , 2));
		
		Collections.sort(employees, new Q7_SortEmployeesByDepartment());
		
		for (int i=0; i<employees.size(); i++) 
			actualsStr += employees.get(i)+" ";
		
		ArrayList<Employee> expecteds = new ArrayList<Employee>();
		expecteds.add(new Employee("abc", "AAA" , 1));
		expecteds.add(new Employee("def", "BBB" , 3));
		expecteds.add(new Employee("ghi", "DDD" , 2));
		
		
		
		for (int i=0; i<employees.size(); i++) 
			expectedsStr += employees.get(i)+" ";
            
		
		assertEquals(expectedsStr, actualsStr);
		
		
		
		
		
		
	}



}
