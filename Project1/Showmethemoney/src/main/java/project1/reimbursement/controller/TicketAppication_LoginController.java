package project1.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import project1.reimbursement.Dao.TicketDao;
import project1.reimbursement.models.Employee;

public class TicketAppication_LoginController {

	public static String login(HttpServletRequest req) {
		
		if(!req.getMethod().equals("POST")) {  //get out ~!!!    get  get  
			return "resources/html/TicketApply.html";
		}
		//		boolean flag = true;
		//		if (flag) {
		//			return "resources/html/TicketApply.html";
		//		}



		HttpSession session = req.getSession();
		TicketDao td = new TicketDao();

		Employee employee= (Employee) session.getAttribute("employee");
		


		String type = req.getParameter("type");
		long amount = Long.parseLong(req.getParameter("Amount"));
		String description = req.getParameter("Description");



		System.out.println(employee.getEmployee_id());



		
		//td.insertTicket(type, amount, "pending", description, employee.getEmployee_id());


		return "resources/html/homepage.html";
	}
}