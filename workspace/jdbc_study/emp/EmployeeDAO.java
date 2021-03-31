package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DATA ACCESS OBJECT =  데이터 직접 접근 객체
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String first, String last){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		//EmployeeDTO [] list = new EmployeeDTO[10];
		try { 
			// jdbc driver 메모리  로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// db 연결
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결성공");
				
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
			st.setInt(1, Integer.parseInt(first));
			st.setInt(2, Integer.parseInt(last));
			
			//실행
			rs = st.executeQuery();
			
			
			//리턴결과 ResultSet - ArrayList<EmployeeDTO> 복사
			while(rs.next()) {//1행 이동
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto);
				
				//System.out.println(r + "|" + emp_name + "|" + salary );
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
			rs.next();
			}catch(SQLException e) { }
		}//finally end
		return list;
	}
}
