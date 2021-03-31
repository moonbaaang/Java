package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pr_PrepareSelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			System.out.println("DB 연결 성공");
			
			//사번이 ? - ? 사이인 사원 조회, 명령행 매개변수 200-300 입력
			String sql = "select * from c_emp "
					+"where emp_id between ? and ?";
			
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(args[0]));
			st.setInt(2, Integer.parseInt(args[1]));
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println(String.format("%-5d|%-20s|%-10s|%-12.2f|%-5d", 
						emp_id, emp_name, title, salary, dept_id));
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				conn.close(); 
				st.close();
				rs.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
