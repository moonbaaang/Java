package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String currentPage, String cntPerPage){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결 성공");
			
			// hr 계정의 employees 테이블 급여 많은 순서를 정렬하여
			// 명령행 매개변수를 입력해 ~번째 사원 이름과 급여 조회
			String sql = "select r, first_name, salary"
					+ " from (select rownum r, first_name, salary"
					+ " from (select * from employees order by salary desc))"
					+ " where r>=? and r<=?";
			
/*			int start = Integer.parseInt(currentPage);
			int end = Integer.parseInt(cntPerPage);
			st.setInt(1, start*end-(end-1)); // 1 1  / /2 6 //3 11/  4 16 4 7 12 
			st.setInt(2, end*start);  
*/
			
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(currentPage));
			st.setInt(2, Integer.parseInt(cntPerPage));
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto);
				
				System.out.println(r + "|" + emp_name + "|" + salary );
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
				rs.next();
			}catch(SQLException e) {}
		}
		return list;
	}
}
