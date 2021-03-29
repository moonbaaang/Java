# DTO, DAO

> DTO : Data transfer object
>
> DAO : Data access object

* EmployeesDTO.java

```java
package emp;
// DTO - DATA TRANSFER OBJECT
// EMPLOYEES 테이블 11개 컬럼들 / 클래스 변수
public class EmployeeDTO { // 1개 EMPLOYEES 행 레코드
	int employee_id, manager_id, department_id;
	String first_name, last_name, email, phone_number, hire_date, job_id;
	double salary, commission_pct;
	//생성자
	//setter, getter
	//toString
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission_pct() {
		return commission_pct;
	}
	public void setCommission_pct(double commission_pct) {
		this.commission_pct = commission_pct;
	}
}

/*
EMPLOYEE_ID                                              NOT NULL NUMBER(6)
FIRST_NAME                                          			  VARCHAR2(20)
LAST_NAME                                                NOT NULL VARCHAR2(25)
EMAIL                                                    NOT NULL VARCHAR2(25)
PHONE_NUMBER                                        			  VARCHAR2(20)
HIRE_DATE                                                NOT NULL DATE
JOB_ID                                                   NOT NULL VARCHAR2(10)
SALARY                                               			  NUMBER(8,2)
COMMISSION_PCT                                       			  NUMBER(2,2)
MANAGER_ID                                            		      NUMBER(6)
DEPARTMENT_ID                                         			  NUMBER(4)
*/
```

* EmployeeDAO.java

```java
package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Data Access Object
public class EmployeeDAO {
	public ArrayList<EmployeeDTO> getEmployees(String currentPage, String cntPerPage){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			System.out.println("db연결 성공");
			
			// hr 계정의 employees 테이블 급여 많은 순서를 정렬하여
			// 명령행 매개변수를 입력해 ~번째 사원 이름과 급여 조회
			String sql = "select r, first_name, salary"
					+ " from (select rownum r, first_name, salary"
					+ " from (select * from employees order by salary desc))"
					+ " where r>=? and r<=?";
			
/*			int start = Integer.parseInt(currentPage);
			int end = Integer.parseInt(cntPerPage);
			st.setInt(1, start*end-(end-1)); // 1 1  / /2 6 //3 11/  4 16 4 7 12 
			st.setInt(2, end*start);  
*/
			
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(currentPage));
			st.setInt(2, Integer.parseInt(cntPerPage));
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("r");
				String emp_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				
				EmployeeDTO dto = new EmployeeDTO();
				dto.setFirst_name(emp_name);
				dto.setSalary(salary);
				list.add(dto);
				
				System.out.println(r + "|" + emp_name + "|" + salary );
			}
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
				rs.next();
			}catch(SQLException e) {}
		}
		return list;
	}
}
```

* PrepareSelectTest3.java

```java
package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.EmployeeDAO;
import emp.EmployeeDTO;

public class pr_PrepareSelectTest3 {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.getEmployees(args[0], args[1]);
		
		
		for(EmployeeDTO dto : list) {
			System.out.println(dto.getFirst_name()+" | "+dto.getSalary());
		}
	} // main end
}
```

