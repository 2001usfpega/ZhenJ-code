package project1.reimbursement.models;

public class Employee {
	
	long employee_id;
	String user_name;
	String password;
	String first_name;
	String last_name;
	boolean is_finance;
	
	public Employee() {};
	
	public Employee(long employee_id, String user_name, String password, String first_name, String last_name,
			boolean is_finance) {
		super();
		this.employee_id = employee_id;
		this.user_name = user_name;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.is_finance = is_finance;
	}

	public long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public boolean isIs_finance() {
		return is_finance;
	}

	public void setIs_finance(boolean is_finance) {
		this.is_finance = is_finance;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", user_name=" + user_name + ", password=" + password
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", is_finance=" + is_finance + "]";
	}
}