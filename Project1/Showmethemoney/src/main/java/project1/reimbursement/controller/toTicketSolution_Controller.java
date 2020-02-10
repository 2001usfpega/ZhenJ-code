package project1.reimbursement.controller;

import javax.servlet.http.HttpServletRequest;

import project1.reimbursement.Dao.TicketDao;

public class toTicketSolution_Controller {

	public static String handleTicket(HttpServletRequest req) {
		
		
		long theNumber = Long.parseLong(req.getParameter("theNumber"));
		String handle_ticket= req.getParameter("handle_ticket");
		
		
		
		System.out.println(theNumber);
		System.out.println(handle_ticket);
		
		TicketDao td = new TicketDao();
		td.updateTicket(theNumber, handle_ticket);
		
		
		
		
		
		return "resources/html/fin_terminal.html";
	}



	
}