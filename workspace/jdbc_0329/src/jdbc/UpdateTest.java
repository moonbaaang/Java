package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class UpdateTest {
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
			
			//jdbc 계정 내 c_emp테이블
			// 600 이자바 사장 10000
			// 자바 "sql" 정의(String으로 취급), db전송, 결과 검색
			//String sql =
			//"insert into c_emp values(600, '이자바', '임원', 10000, 10)";
			// sql에서는 문자를 단일따옴표 안에 넣음, 마지막 세미콜론은 넣지 않음, sql문법이 잘못돼도 자바에서는 오류가 발생하지 않는다.
			
			// 700 김자바 임원 10000 10 >> 명령행 매개변수로 입력
			 String sql = "insert into c_emp values(" + args[0] +", '"+args[1]+"', '"+args[2]+"', "+args[3]+", " +args[4]+")";
			
			
			Statement st = conn.createStatement();
			// db로 전송하는 객체 - Statement의 도움을 받아야함, sql을 Statement 객체를 통해 conn으로 전송
		
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
