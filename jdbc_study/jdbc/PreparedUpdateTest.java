package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedUpdateTest {
//1. 오라클 자동 시작 2.ojdbc6.jar  설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pt = null;
		try { 
			// jdbc driver 메모리  로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("db연결성공");
				
			//대리 5000 --> 명령행 매개변수로 입력받으면 c_emp 테이블  title 대리인 직원의 현재 급여에 5000 인상=급여변경
	
			/* c_emp 테이블 제약조건 설정 ?????
			select constraint_name, constraint_type, search_condition, table_name
    		from user_constraints
  			where LOWER(table_name)='c_emp'
			 * */
			//자동 commit  기본- 수동 설정 변경 가능.PreparedStatement  변경
			String sql = "update c_emp set salary = salary + ? where title = ?";
			
			//delete from c_emp where emp_id>=?
			
            //sql  저장 객체 생성
			pt = conn.prepareStatement(sql);
			//sql 입력파라미터값 세팅
			pt.setInt(1, Integer.parseInt(args[1]));
			pt.setString(2, args[0]);
			//sql 실행
			int rowcnt = pt.executeUpdate();
			//실행결과 출력
			System.out.println(rowcnt);
			
			//setString 이랑                         setNString은 차이없나요 ?
            //오라클 varchar2 타입(3바이트)   오라클 nvarchar2 타입(2바이트)
					
			System.out.println("db연결해제성공");	
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		}catch(SQLException e) {
			System.out.println("DB연결정보 확인하세요");
			e.printStackTrace();//자세한 원인 출력
		}finally {
			try {
			pt.close();
			conn.close();
			}catch(SQLException e) { }
		}
	}

}
