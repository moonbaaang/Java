package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedSelectTest {
//1. 오라클 자동 시작 2.ojdbc6.jar  설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try { 
			// jdbc driver 메모리  로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			
			String sql = "select * from c_emp where emp_id between ? and ?";//사번 200 - 300 사이 사원 조회";
			//sql 저장 -  문법검사 - 실행 준비 상태
			st = conn.prepareStatement(sql);
			st.setInt(1, 200);
			st.setInt(2, 300);
			
			//실행
			rs = st.executeQuery();
			
			//리턴결과 검색
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println
				(emp_id+"|" + emp_name + "|" + title + "|" + salary + "|" + dept_id);
			}

			
			System.out.println("db연결해제성공");	
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 원인 출력
		}finally {
			try {
			rs.close();
			st.close();
			conn.close();
			}catch(SQLException e) { }
		}
	}

}
