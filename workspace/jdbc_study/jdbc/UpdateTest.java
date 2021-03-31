package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateTest {
//1. 오라클 자동 시작 2.ojdbc6.jar  설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try { 
			// jdbc driver 메모리  로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
			//이자바 사원을 사번 100 인 사원과 같은 직급(title)으로 변경
			
			//대리 5000 --> 명령행 매개변수로 입력받으면 c_emp 테이블  title 대리인 직원의 현재 급여에 5000 인상=급여변경
			
			
			/* update 테이블명 
			 * set 변경컬럼이름=변경값
			 * whereh 변경조건식
			 * update c_emp set title = (select title from c_emp where emp_id=100)
			 * where emp_name = '이자바'
			 *  */
			/* c_emp 테이블 제약조건 설정 ?????
			select constraint_name, constraint_type, search_condition, table_name
    		from user_constraints
  			where LOWER(table_name)='c_emp'
			 * */
			//자동 commit  기본- 수동 설정 변경 가능
			String sql = 
//			"update c_emp set title = (select title from c_emp where emp_id=100)"
//			+ 
//			" where emp_name = '이자바'";
            "update c_emp set salary = salary + " + args[1] + " where title = '" + args[0] + "'";
			
			//"delete c_emp where emp_id=100"
			//db 전송
			st = conn.createStatement();
			//실행
			int updaterow = st.executeUpdate(sql);
			//리턴결과 검색
			System.out.println(updaterow+"  개의 행 수정");
			
			
			System.out.println("db연결해제성공");	
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 원인 출력
		}finally {
			try {
			st.close();
			conn.close();
			}catch(SQLException e) { }
		}
	}

}
