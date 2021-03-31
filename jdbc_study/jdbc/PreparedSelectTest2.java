package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedSelectTest2 {
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
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");
			
			// hr 계정의 employees 테이블 급여 많은순서 정렬하여 
			// ?- ?번째 사원 이름과 급여 조회
			// rownum, row_number(), rank(), dense_rank()
			/*
			1. select rownum , salary
				from ( select * from employees order by salary desc)
			where rownum between 11 and 20;
			--> rownum select 되는 레코드행번호 생성
			    rownum ">=" ">"  실행안된다( 단 1인 경우 제외)
			    rownum >=11  
			    rownum > 11
			--->
			
			1.
			select r, salary
			from(  select rownum r , salary
			       from ( select * from employees order by salary desc)
			    )
			where r >= 11 and r <=20;
			  
			2. 
			select r, salary
			from (select row_number() over(order by salary desc ) as r, salary
			      from employees)
			where r between 11 and 20;
	        
	        3.
			select r, salary
			from (select rank() over(order by salary desc ) as r, salary
			      from employees)
			where r between 11 and 20;
			
			
			
			select r, salary
			from (select dense_rank() over(order by salary desc ) as r, salary
			      from employees)
			where r <= 10
			
			*/
			
			// hr 계정의 employees 테이블 급여 많은순서 정렬하여 
			// (명령행 매개변수 입력)  명번째 사원 이름과 급여 조회
			String sql = "select r, first_name, salary"
					+" from (SELECT rownum r, first_name, salary"
					+"       from (select * from employees order by salary desc)"
					+"      )"
					+ "	where r >= ? and r <= ?";
	
			//sql 저장 -  문법검사 - 실행 준비 상태
			st = conn.prepareStatement(sql);
			
			//입력파라미터값 세팅
			st.setInt(1, Integer.parseInt(args[0]));
			st.setInt(2, Integer.parseInt(args[1]));
			
			//실행
			rs = st.executeQuery();
			
			//리턴결과 검색
			while(rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				System.out.println(r + "|" + emp_name + "|" + salary );
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
