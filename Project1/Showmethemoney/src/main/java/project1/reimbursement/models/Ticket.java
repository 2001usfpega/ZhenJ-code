package project1.reimbursement.models;

public class Ticket {
	
	long ticket_id;
	String ticket_type;
	long amount;
	String date_submitted;
	String date_resolved;
	String status;
	String c_description;
	long employee_id;
	
	public Ticket() {}

	public Ticket(long ticket_id, String ticket_type, long amount, String date_submitted, String date_resolved,
			String status, String c_description, long employee_id) {
		super();
		this.ticket_id = ticket_id;
		this.ticket_type = ticket_type;
		this.amount = amount;
		this.date_submitted = date_submitted;
		this.date_resolved = date_resolved;
		this.status = status;
		this.c_description = c_description;
		this.employee_id = employee_id;
	}

	public long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(String date_submitted) {
		this.date_submitted = date_submitted;
	}

	public String getDate_resolved() {
		return date_resolved;
	}

	public void setDate_resolved(String date_resolved) {
		this.date_resolved = date_resolved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getC_description() {
		return c_description;
	}

	public void setC_description(String c_description) {
		this.c_description = c_description;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", ticket_type=" + ticket_type + ", amount=" + amount
				+ ", date_submitted=" + date_submitted + ", date_resolved=" + date_resolved + ", status=" + status
				+ ", c_description=" + c_description + ", employee_id=" + employee_id + "]";
	}
}
