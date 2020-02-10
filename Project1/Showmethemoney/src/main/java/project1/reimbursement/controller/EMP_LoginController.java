package project1.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import project1.reimbursement.Dao.EmployeeDao;
import project1.reimbursement.models.Employee;

public class EMP_LoginController {

	public static String login(HttpServletRequest req) {
		
		


		if(!req.getMethod().equals("POST")) {  //get out ~!!!    get  get  
			return "resources/html/emp_Login.html";
		}

		String username= req.getParameter("username-applicant");
		String password= req.getParameter("password-applicant");
		
	

		EmployeeDao ed = new EmployeeDao();

		Employee employee = ed.selectEmployeeByUserName(username);
		
		if (employee == null )
			return "resources/html/emp_Login.html";


		if ( employee.getPassword().contentEquals(password)) {
			


			HttpSession session = req.getSession();
			session.setAttribute("employee", employee);
			

			return "resources/html/TicketApply.html";
		} else {
			//if login fail
			return "resources/html/emp_Login.html";
		}
	}
}