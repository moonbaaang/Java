package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO DATA ACCESS OBJECT = 데이터에 직접 접근
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String currentPage, String cntPerPage){ // 2 5 일 때 2페이지 (5개씩)
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			// jdbc driver 메모리 로드, db종류마다 () 내부 내용이 다름
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//db 연결 
			conn = DriverManager.getConnection
					("jdbc:oracl:thin:@127.0.0.1:1521:xe","hr","hr");
			// 127.0.0.1 내 컴퓨터 라는 의미 ,xe , hr 계정, 암호
			// 4명이 한대의 db 사용 시 > 실제 @ip address 가 필요하다.
			System.out.println("db연결 성공");
			
			// hr계정의 employees 테이블 급여 많은 순서로 정렬
			// (명령행 매개변수 입력) ~ 번째 사원 이름과 급여 조회
			String sql = "select first_name, salary "
						+"from (select rownum r, first_name, salary "
						+"from (select * from employees order by salary desc)) "
						+"where r>=? and r<=?";
			
			// 2 5 일 때 2페이지 (5개씩)
			int start = Integer.parseInt(currentPage);
			int end = Integer.parseInt(cntPerPage);
			st.setInt(1, start*end-(end-1)); // 1 1  / /2 6 //3 11/  4 16 4 7 12 
			st.setInt(2, end*start); // 
			
			st = conn.prepareStatement(sql); //sql 저장 - 문법검사 - 실행준비상태
			//st.setInt(1, Integer.parseInt(currentPage);
			//st.setInt(2, Integer.parseInt(cntPerPage); 
			
			rs = st.executeQuery(); // 실행할 때는 지정 X  
			// 실행

			list = new ArrayList<EmployeeDTO>();
			
			while(rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				Double salary = rs.getDouble("salary");
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto); // list로 복사되고있다.
				System.out.println(r+"|"+emp_name+"|"+salary);
			}
			
			
/*			풀이 1) rownum
			select rownum, salary
			from (select * from employees order by salary desc)
			where rownum between 11 and 20;
			-> rownum >= 실행 불가능(1인경우 제외), 비교연산자 사용 불가능		
			
			select r, salary
			from( select rownum r, salary
			from (select * from employees order by salary desc))
			where r between 11 and 20;
*/		
			
/*			풀이 2) row_number()
 * 			select r, salary
 * 			from (select row_number() over(order by salary desc) as r, salary from employees)
 * 			where r <= 10; 
 * 			>> from employees 라고만 하면 where절 실행 시 r은 생성되지도 않았음 from - where - select (where절이 먼저 실행)	
 */
/*			풀이 3) rank()
 * 			select r, salary
 * 			from (select rank() over(order by salary desc) as r, salary from employees)
 * 			where r <= 10; 
 * 
 * 			풀이 4) dense_rank()
 * 			select r, salary
 * 			from (select dense_rank() over(order by salary desc) as r, salary from employees)
 * 			where r <= 10; 
 */
			// 페이징 처리!!
			
/*			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println
				(emp_id+"|"+emp_name+"|"+title+"|"+salary+"|"+dept_id);
			}
*/			
			
		} catch(ClassNotFoundException e) { //name 오타가 있을 때, ojdbc 세팅이 안되어있을 때
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) { //계정 명 또는 암호 불일치
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
				rs.next();
				System.out.println("db연결 해제 성공");
			} catch(SQLException e) {e.printStackTrace();} // 예외처리 한번 더 필요
		}//finally end
		return list;
	}
}
