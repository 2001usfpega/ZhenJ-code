package project1.reimbursement.Dao;

import java.util.List;

import project1.reimbursement.models.Employee;

public interface EmployeeDaoInterface {
	
	public int insertEmployee(String user_name, String password, String first_name,
			String last_name, boolean is_finance);
	
	
	//READ
	public List<Employee> selectAllEmployees();
	
	
	public Employee selectEmployeeById(long employee_id);
	
	
	public Employee selectEmployeeByUserName(String name);// maybe
	//UPDATE
	public boolean updateEmployee(long employee_id, String user_name); // maybe
	//DELETE
	public boolean deleteEmployee(long employee_id);  //maybe

}
