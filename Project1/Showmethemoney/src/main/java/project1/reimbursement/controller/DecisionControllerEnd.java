package project1.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import project1.reimbursement.Dao.EmployeeDao;
import project1.reimbursement.models.Employee;

public class DecisionControllerEnd {
	
	
	
	public static String show(HttpServletRequest req) {
		return "resources/html/404.html";
	}
}