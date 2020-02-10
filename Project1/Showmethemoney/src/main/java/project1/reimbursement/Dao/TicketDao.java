package project1.reimbursement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project1.reimbursement.models.Ticket;

public class TicketDao implements TicketDaoInterface {

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
	public int insertTicket( String ticket_type, long amount, String status,
			String c_description, long employee_id) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			/*
			 * prepared statement guard against sql injection because it is pre-compiled
			 *  (which also makes it faster)
			 */
			String sql= "INSERT INTO ticket(ticket_type, amount, date_submitted, status, c_description, employee_id) VALUES(?, ?, CURRENT_date, ?, ?, ?)";

			//			byte[] emp_pw = employee.getEmp_pw().getBytes(); // in case I want to set password BLOB
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ticket_type); //first question mark
			ps.setLong(2, amount);  //second question mark
			ps.setString(3, status);
			ps.setString(4, c_description);
			ps.setLong(5, employee_id);

			ps.executeUpdate();
			return 1;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public List<Ticket> selectAllTickets() {
		List<Ticket> tickets = new ArrayList<>();


		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ticket ORDER BY ticket_id";

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) {

				tickets.add(
						new Ticket( rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return tickets;
	}

	@Override
	public Ticket selectTicketById(long ticket_id) {
		List<Ticket> tickets = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ticket WHERE ticket_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, ticket_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				tickets.add(
						new Ticket( rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return (tickets.get(0) != null)? tickets.get(0): null;
	}

	@Override
	public List<Ticket> selectTicketByEmployeeID(long employee_id) {
		List<Ticket> tickets = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM ticket WHERE employee_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, employee_id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				tickets.add(
						new Ticket( rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8))
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public boolean updateTicket(long ticket_id, String status) {

		try(Connection conn = DriverManager.getConnection(url,username,password)){
			String sql= "UPDATE ticket SET status=?,date_resolved=CURRENT_date WHERE ticket_id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, status);
			ps.setLong(2, ticket_id);


			//System.out.println(sql);
			if(ps.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTicket(long ticket_id) {
		List<Ticket> tickets = new ArrayList<>();
		tickets = selectAllTickets();
		boolean flag = false;
		for (int i=0; i< tickets.size(); i++) {

			if (tickets.get(i).getTicket_id() == ticket_id) {
				flag = true;
				break;
			}
		}
		if(flag == false) {
			return false;
		}

		try(Connection conn = DriverManager.getConnection(url,username,password)){

			String sql="DELETE FROM ticket WHERE ticket_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, ticket_id);
			if(ps.executeUpdate()>0) {
				return true;
			}			
			//System.out.println(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}