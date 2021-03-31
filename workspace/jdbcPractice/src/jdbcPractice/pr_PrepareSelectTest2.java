package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pr_PrepareSelectTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			
			System.out.println("DB 연결 성공");
			
			// hr계정의 employees 테이블 급여 많은 순서로 정렬
			// (명령행 매개변수 입력) ~ 번째 사원 이름과 급여 조회
			String sql = "select r, first_name, salary "
					+ "from (select rownum r, first_name, salary "
					+ "from (select * from employees order by salary desc)) "
					+ "where r>=? and r<=?";
			
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(args[0]));
			st.setInt(2, Integer.parseInt(args[1]));
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("r");
				String first_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				System.out.println(String.format("%-3d|%-20s|%-12.2f",
						r, first_name, salary));
			}
			
			
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
