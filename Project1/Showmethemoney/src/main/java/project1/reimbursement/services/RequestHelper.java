package project1.reimbursement.services;

import javax.servlet.http.HttpServletRequest;

import project1.reimbursement.controller.EMP_LoginController;
import project1.reimbursement.controller.FIN_LoginController;
import project1.reimbursement.controller.Ticket_submit_Controller;
import project1.reimbursement.controller.toTicketSolution_Controller;

public class RequestHelper {

	public static String process(HttpServletRequest req){
		System.out.println(req.getRequestURI());

		switch(req.getRequestURI()) {



		case "/Showmethemoney/toEmployeeLogIn":			// employee login 

			return "resources/html/emp_Login.html";   


		case "/Showmethemoney/toFinaceLogIn":			// finance login 


			return "resources/html/fin_Login.html";


		case "/Showmethemoney/toTicketApply":      // log in as employee applicant


			return EMP_LoginController.login(req);


		case "/Showmethemoney/toTicketSubmit":
			
			return Ticket_submit_Controller.login(req);
			
		case "/Showmethemoney/toTicketManagement":
			
			return FIN_LoginController.login(req);
			
		case "/Showmethemoney/toTerminal":
			
			return "resources/html/fin_terminal";
			
		case "/Showmethemoney/toTicketSolution":
			
			return toTicketSolution_Controller.handleTicket(req);
			
		case "/Showmethemoney/toLeave":
			
			return "resources/html/homepage.html";



		default:

			return "resources/html/404.html";
		}

	}
}


//  NewExpense.do