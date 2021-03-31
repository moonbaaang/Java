package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pr_UpdateTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("DB 연결 성공");
			
			// 이자바 사원을 사번 100인 사원과 같은 직급(title)로 변경
			String sql = 
					"update c_emp set title = (select title from c_emp where emp_id = 100) "
					+
					"where emp_name = '이자바'";
			
			st = conn.createStatement();
			int insertrow = st.executeUpdate(sql);
			System.out.println(insertrow+ "개의 행 삽입");
			
		} catch(ClassNotFoundException e) {
			// name에 오타, ojdbc 세팅이 안되어있을 때
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				conn.close(); // 반드시 처리해야하는 문장
				st.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
