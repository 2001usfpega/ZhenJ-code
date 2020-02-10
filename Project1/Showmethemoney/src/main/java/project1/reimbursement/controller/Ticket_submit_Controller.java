package project1.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import project1.reimbursement.Dao.EmployeeDao;
import project1.reimbursement.Dao.TicketDao;
import project1.reimbursement.models.Employee;

public class Ticket_submit_Controller {

	public static String login(HttpServletRequest req) {
		
		if(!req.getMethod().equals("POST")) {  //get out ~!!!    get  get  
			return "resources/html/TicketApply.html";
		}

		HttpSession session = req.getSession();
		TicketDao td = new TicketDao();

		Employee employee= (Employee) session.getAttribute("employee");
		


		String type = req.getParameter("type");
		long amount = Long.parseLong(req.getParameter("Amount"));
		String description = req.getParameter("Description");
		
		td.insertTicket(type, amount, "pending", description, employee.getEmployee_id());

		session.invalidate();

		return "resources/html/emp_Login.html";
	}
}