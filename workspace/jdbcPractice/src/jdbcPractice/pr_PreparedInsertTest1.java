package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pr_PreparedInsertTest1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			System.out.println("DB 연결 성공");

			String sql = "insert into c_emp values(?,?,?,?,?)";
			// 실행 sql의 형태를 잡은 상태이다.
			
			st = conn.prepareStatement(sql);
			st.setInt(1, 900);
			st.setNString(2, "김신입");
			st.setString(3, "사원");
			st.setDouble(4, 10000.99);
			st.setInt(5, 20);		
			
			int insertrow = st.executeUpdate();
			
			System.out.println(insertrow+"개 행 삽입");
			
		} catch(ClassNotFoundException e) {
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
