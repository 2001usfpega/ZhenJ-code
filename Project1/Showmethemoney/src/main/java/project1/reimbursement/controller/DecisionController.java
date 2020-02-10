package project1.reimbursement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import project1.reimbursement.Dao.TicketDao;
import project1.reimbursement.models.Employee;
import project1.reimbursement.models.Ticket;

public class DecisionController {



	public static void show(HttpServletRequest req,HttpServletResponse res) throws JsonProcessingException, IOException {

		TicketDao td = new TicketDao();
		List<Ticket> tickets = td.selectAllTickets();

		PrintWriter out = res.getWriter();

		out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\">\n" + 
				"<title>Ticket Decision</title>\n" + 
				"<link rel=stylesheet type=\"text/css\" href=\"/Showmethemoney/resources/css/mystyles.css\"></head>\n" + 
				"<div class=\"login-container\"><div class=\"form-group\"><table border=\"2\" class=\"table\" id=\"reimbtable\"><th>ticket_id</th><th>ticket_type</th><th>amount</th><th>date_submitted</th><th>date_resolved</th><th>status</th><th>c_description</th><th>employee_id</th>");
		
		for (int i =0 ; i< tickets.size() ; i++) {
			
				out.println("<tr>" );
				out.println("<td>" + tickets.get(i).getTicket_id() + "</td>");
				out.println("<td>" + tickets.get(i).getTicket_type() + "</td>");
				out.println("<td>" + tickets.get(i).getAmount() + "</td>");
				out.println("<td>" + tickets.get(i).getDate_submitted() + "</td>");
				out.println("<td>" + tickets.get(i).getDate_resolved() + "</td>");
				out.println("<td>" + tickets.get(i).getStatus() + "</td>");
				out.println("<td>" + tickets.get(i).getC_description() + "</td>");
				out.println("<td>" + tickets.get(i).getEmployee_id()+ "</td>");
				out.println("</tr>");	
		}
		out.println("</table></div>");
		out.println("<form class=\"\" id=\"TypeForm\" method=\"POST\" action=\"toTicketSolution\"><input type=\"number\" class=\"form-control\"name=\"theNumber\""
				+ " aria-label=\"Amount (to the nearest dollar)\"><div class=\"dropdown\"><select class=\"btn-lg\" class=\"ui dropdown\" name=\"handle_ticket\"form="
				+ "\"TypeForm\"><option value=\"\" selected disabled>Result</option><option value=\"Approved\">Approved</option><option value=\"Denied\">Denied</option></select><input type=\"Submit\" class=\"form-control btn\" id=\"SubmitButton\"value=\"Submit\"> <br /> <br /></div></form>");
		out.println("</div>");
		
		out.print("<form method=\"post\" action=\"/Showmethemoney/toEmployeeLogIn\"><p>Back to</p><input type=\"submit\" value=\"Main\" /></form>");
		out.println("</body></html>");








	}
}
