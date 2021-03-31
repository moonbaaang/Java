package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;

public class SelectTest2 {
// 오라클 자동시작 - ojdbc6.jar 설치, 이클립스 세팅
	public static void main(String[] args) { // String... args 비정형 매개변수
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// jdbc driver 메모리 로드, db종류마다 () 내부 내용이 다름
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//db 연결 
			conn = DriverManager.getConnection
					("jdbc:oracl:thin:@127.0.0.1:1521:xe","hr","hr");
			// 127.0.0.1 내 컴퓨터 라는 의미 ,xe , hr 계정, 암호
			// 4명이 한대의 db 사용 시 > 실제 @ip address 가 필요하다.
			System.out.println("db연결 성공");
			

			String sql = "select employee_id, first_name, job_id, salary, department_id, "
					+
					"to_char(hire_date, 'yyyy:mm:dd HH24:MMmi:ss') as h_date "
					+
					"from employees";
			st = conn.createStatement();
			// db로 전송하는 객체 - Statement의 도움을 받아야함, sql을 Statement 객체를 통해 conn으로 전송
			
			rs = st.executeQuery(sql);
			// 실행
			
			while(rs.next()) {
				int emp_id = rs.getInt("employee_id");
				String emp_name = rs.getString("first_name");
				String title = rs.getString("job_id");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("department_id");
				//Date hire_date = rs.getDate("hire_date"); //java.sql.Date (4-2-2) oracle (2/2/2)
				String hire_date = rs.getString("h_date");
				System.out.println
				(emp_id+"|"+emp_name+"|"+title+"|"+salary+"|"+dept_id+"|"+hire_date);
			//	System.out.println(hire_date);
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
