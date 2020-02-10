package project1.reimbursement.Dao;

import java.util.List;

import project1.reimbursement.models.Ticket;

public interface TicketDaoInterface {
	
	
	//CREATE
	public int insertTicket( String ticket_type, long amount, String status,
			String c_description, long employee_id);
	
	//READ
	public List<Ticket> selectAllTickets();
	public Ticket selectTicketById(long id);
	public List<Ticket> selectTicketByEmployeeID(long employee_id);
	
	//UPDATE
	public boolean updateTicket( long ticket_id, String status );
	//update statue (pending, approval, deny)
	
	//DELETE
	public boolean deleteTicket(long ticket_id);
	// ticket can be delete by applicant

}