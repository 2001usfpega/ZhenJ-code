package project1.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;

import project1.reimbursement.Dao.EmployeeDao;
import project1.reimbursement.models.Employee;

public class FIN_LoginController {

	public static String login(HttpServletRequest req) {
		
		


		if(!req.getMethod().equals("POST")) {  //get out ~!!!    get  get  
			return "resources/html/fin_Login.html";
		}

		String username= req.getParameter("username-fin");
		String password= req.getParameter("password-fin");
		
		
		
		System.out.println(username);
		System.out.println(password);

		EmployeeDao ed = new EmployeeDao();
		Employee employee = new Employee();

		employee = ed.selectEmployeeByUserName(username);
		
		if (employee == null )
			return "resources/html/fin_Login.html";


		if ( employee.getPassword().contentEquals(password)) {

			req.getSession().setAttribute("employee", employee);

			return "resources/html/fin_terminal.html"; //another way to return
		} else {
			//if login fail
			return "resources/html/fin_Login.html";
		}
	}
}