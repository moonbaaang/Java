package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class InsertTest {
// 오라클 자동시작 - ojdbc6.jar 설치, 이클립스 세팅
	public static void main(String[] args) { // String... args 비정형 매개변수
		Connection conn = null;
		try {
			// jdbc driver 메모리 로드, db종류마다 () 내부 내용이 다름
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//db 연결 
			conn = DriverManager.getConnection
					("jdbc:oracl:thin:@127.0.0.1:1521:xe","jdbc","jdbc");
			// 127.0.0.1 내 컴퓨터 라는 의미 ,xe , hr 계정, 암호
			// 4명이 한대의 db 사용 시 > 실제 @ip address 가 필요하다.
			System.out.println("db연결 성공");
			
			// 이자바 사원을 사번 100인 사원과 같은 직급(title)로 변경
/*			String sql =
			"update c_emp set title = (select title from c_emp where emp_id=100)"
			+
			"where emp_name = '이자바'";
*/			// 문장이 길어  +로 구분함
			
//			String sql = "update c_emp set title = '대리'" 만 실행했을 경우?
//	update는 문제가 없음
// "select * from c_emp"
// +
// "where id=100"
// select * from c_empwhere id=100 이렇게 표현이 되어 sql문장이 잘못되게 된다. 
// update는 문제가 없더라도 sql문장에서는 공백이 있어야 하는 자리에는 정확하게 공백이 있어야 한다.

			
			// 대리 5000 > 명령행 매개변수로 입력받으면 c_emp 테이블 title이 대리인 직원의 현재 급여에 5000 인상
			String sql =
			"update c_emp set salary = salary + "+args[1]+"where title='" + args[0] + "'";
			
			// jdbc에서는 자동 commit (수동으로 하는 방법도 있긴 함)
			
			// "delete c_emp where emp_id = 100" 삭제방법
			
			
			Statement st = conn.createStatement();
			// db로 전송 - Statement의 도움을 받아야함 sql을 Statement 를 통해 conn으로 전송
		
			int updaterow = st.executeUpdate(sql);
			// 실행
			
			System.out.println(updaterow+ " 개의 행 삽입");
			// 리턴결과 검색
			
			//insert into c_emp select * from a
			
		} catch(ClassNotFoundException e) { //name 오타가 있을 때, ojdbc 세팅이 안되어있을 때
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) { //계정 명 또는 암호 불일치
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {
				conn.close(); //tcp 소켓, 파일 close() (반드시 처리해야하는 문장)
				System.out.println("db연결 해제 성공");
			} catch(SQLException e) {} // 예외처리 한번 더 필요
		}
	}

}
