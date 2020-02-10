package project1.reimbursement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project1.reimbursement.models.Employee;

public class EmployeeDao implements EmployeeDaoInterface {
	
	private static String url= System.getenv("DB_url");
	private static String username= System.getenv("DB_userName");
	private static String password=System.getenv("DB_pw");
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertEmployee(String user_name, String pass_word, String first_name, String last_name,
			boolean is_finance) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			/*
			 * prepared statement guard against sql injection because it is pre-compiled
			 *  (which also makes it faster)
			 */
			String sql= "INSERT INTO employee(user_name, password, first_name, last_name, is_finance) VALUES(?, ?, ?, ?, ?)";

			//			byte[] emp_pw = employee.getEmp_pw().getBytes(); // in case I want to set password BLOB
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_name); //first question mark
			ps.setString(2, pass_word);  //second question mark
			ps.setString(3, first_name);
			ps.setString(4, last_name);
			ps.setBoolean(5, is_finance);

			ps.executeUpdate();
			return 1;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<>();


		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM employee ORDER BY employee_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) {

				employees.add(
						new Employee( rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	

	@Override
	public Employee selectEmployeeById(long employee_id) {
		List<Employee> employees = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM employee WHERE employee_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, employee_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				employees.add(
						new Employee( rs.getLong(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getBoolean(6))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (employees.get(0) != null)? employees.get(0): null;
	}

	@Override
	public Employee selectEmployeeByUserName(String user_name) {
		List<Employee> employees = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM employee WHERE user_name=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_name);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				employees.add(
						new Employee( rs.getLong(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getBoolean(6))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (employees.get(0) != null)? employees.get(0): null;
	}

	@Override
	public boolean updateEmployee(long employee_id, String user_name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(long employee_id) {
		// TODO Auto-generated method stub
		return false;
	}

}
