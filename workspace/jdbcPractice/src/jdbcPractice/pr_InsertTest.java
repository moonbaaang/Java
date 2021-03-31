package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pr_InsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("DB 연결 성공");

			// jdbc  계정 c_emp  테이블에 데이터 저장
			// 700 김자바 임원 10000 10  --> 명령행 매개변수로 입력
			String sql = 
					"insert into c_emp "
					+"values("+args[0]+",'"+args[1]+"','"+args[2]+"',"
					+args[3]+","+args[4]+")";
			
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
