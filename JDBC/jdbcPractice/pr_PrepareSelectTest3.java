package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.EmployeeDAO;
import emp.EmployeeDTO;

public class pr_PrepareSelectTest3 {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.getEmployees(args[0], args[1]);
		
		
		for(EmployeeDTO dto : list) {
			System.out.println(dto.getFirst_name()+" | "+dto.getSalary());
		}
	} // main end
}
