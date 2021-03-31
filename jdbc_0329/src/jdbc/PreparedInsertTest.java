package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class PreparedInsertTest {
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
			String sql = "insert into c_emp values(?,?,?,?,?)"; //Statement는 전송 불가능
			// 실행할 sql의 형태만 잡은 상태, 문법검사 마치고 준비 상태
			
			PreparedStatement st = conn.prepareStatement(sql);
			// db로 전송 - Statement의 도움을 받아야함 sql을 Statement 를 통해 conn으로 전송
			// ? 부분 값 세팅 = sql문장 입력파라미터 값 세팅
			
			st.setInt(1, 800);
			st.setString(2, "김신입"); //단일 따옴표 아님!! oracle varchar2로 변경 > ''자동변환
			st.setString(3, "사원");
			st.setDouble(4, 10000.99);
			st.setInt(5, 10);
			
			// 실행
			int insertrow = st.executeUpdate(sql);
			
			System.out.println(insertrow+" 개의 행 삽입");
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
