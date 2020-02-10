package project1.reimbursement.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import project1.reimbursement.controller.DecisionController;
import project1.reimbursement.controller.DecisionControllerEnd;



public class DecisionHelper {

	
	
	public static void  process(HttpServletRequest req, HttpServletResponse response) throws JsonProcessingException, IOException{
		System.out.println(req.getRequestURI());

		switch(req.getRequestURI()) {

		case "/Showmethemoney/toDecision":			// employee login 
 
			DecisionController.show(req, response);
			
			
		case "/Showmethemoney/toContinue":
			
			DecisionController.show(req, response);
			


		default:

			DecisionControllerEnd.show(req);
		}


	}
}