import project1.reimbursement.Dao.EmployeeDao;

public class DaoTesting {


	
	public static void main(String[] args) {
		

		EmployeeDao ed = new EmployeeDao();

		ed.insertEmployee("admin", "123", "admin", "people", false);

		System.out.println(ed.selectAllEmployees());

	}

}