package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pr_InsertTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("DB 연결 성공");
			
			//jdbc 계정 내 c_emp테이블
			// 600 이자바 사장 10000 10 입력
			String sql = 
					"insert into c_emp "
					+"values(1000, '정과장', '과장', 9000.5, 30)";
			
			st = conn.createStatement();
			int insertrow = st.executeUpdate(sql);
			
			System.out.println(insertrow+"개의 행 삽입");
			

		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info!");
		} finally {
			try {
				conn.close();
				st.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
