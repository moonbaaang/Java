package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class PreparedSelectTest {
// 오라클 자동시작 - ojdbc6.jar 설치, 이클립스 세팅
	public static void main(String[] args) { // String... args 비정형 매개변수
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// jdbc driver 메모리 로드, db종류마다 () 내부 내용이 다름
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//db 연결 
			conn = DriverManager.getConnection
					("jdbc:oracl:thin:@127.0.0.1:1521:xe","jdbc","jdbc");
			// 127.0.0.1 내 컴퓨터 라는 의미 ,xe , hr 계정, 암호
			// 4명이 한대의 db 사용 시 > 실제 @ip address 가 필요하다.
			System.out.println("db연결 성공");
			

			//String sql = "select * from c_emp";
			String sql = "select * from c_emp where emp_id between ? and ?"; //사번이 200-300 사이인 사원 조회, 명령행 매개변수 입력
			st = conn.prepareStatement(sql); //sql 저장 - 문법검사 - 실행준비상태
			st.setInt(1, 200);
			st.setInt(2, 300);
			
			rs = st.executeQuery(); // 실행할 때는 지정 X  
			// 실행
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println
				(emp_id+"|"+emp_name+"|"+title+"|"+salary+"|"+dept_id);
			}
			
			// 패키지명.클래스명@16진수 > 주소
			System.out.println(rs); // toString() 
			// 리턴결과 검색
			
			//insert into c_emp select * from a
			
		} catch(ClassNotFoundException e) { //name 오타가 있을 때, ojdbc 세팅이 안되어있을 때
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) { //계정 명 또는 암호 불일치
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {
				rs.close(); //tcp 소켓, 파일 close() (반드시 처리해야하는 문장)
				st.close();
				conn.close();
				System.out.println("db연결 해제 성공");
			} catch(SQLException e) {} // 예외처리 한번 더 필요
		}
	}

}
