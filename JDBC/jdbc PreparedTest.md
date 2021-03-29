# JDBC PreparedTest

> PreparedStatement를 이용한 예제입니다.

* c_emp테이블에 (900, 김신입, 사원, 10000.99, 20) 정보를 담은 행 하나를 추가한다.
  * PreparedInsertTest.java

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class pr_PreparedInsertTest1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			System.out.println("DB 연결 성공");

			String sql = "insert into c_emp values(?,?,?,?,?)";
			// 실행 sql의 형태를 잡은 상태이다.
			
			st = conn.prepareStatement(sql);
			st.setInt(1, 900);
			st.setNString(2, "김신입");
			st.setString(3, "사원");
			st.setDouble(4, 10000.99);
			st.setInt(5, 20);		
			
			int insertrow = st.executeUpdate();
			System.out.println(insertrow+"개 행 삽입");
			
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				conn.close(); // 반드시 처리해야하는 문장
				st.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
```

* 이번에는 사번이 ? - ? 사이인 사원을 조회해본다. 
  * 명령행 매개변수 ? - ? 를 입력한다.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pr_PrepareSelectTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			
			System.out.println("DB 연결 성공");
			
			//사번이 ? - ? 사이인 사원 조회, 명령행 매개변수 200-300 입력
			String sql = "select * from c_emp "
					+"where emp_id between ? and ?";
			
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(args[0]));
			st.setInt(2, Integer.parseInt(args[1]));
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String title = rs.getString("title");
				double salary = rs.getDouble("salary");
				int dept_id = rs.getInt("dept_id");
				System.out.println(String.format("%-5d|%-20s|%-10s|%-12.2f|%-5d", 
						emp_id, emp_name, title, salary, dept_id));
			}
			
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				conn.close(); 
				st.close();
				rs.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
```

* hr계정의 employees 테이블을 급여 많은 순서로 정렬
  * (명령행 매개변수 입력) ~ 번째부터 ~번째 사원 이름과 급여 조회

```java
package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pr_PrepareSelectTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			
			System.out.println("DB 연결 성공");
			
			// hr계정의 employees 테이블 급여 많은 순서로 정렬
			// (명령행 매개변수 입력) ~ 번째 사원 이름과 급여 조회
			String sql = "select r, first_name, salary "
					+ "from (select rownum r, first_name, salary "
					+ "from (select * from employees order by salary desc)) "
					+ "where r>=? and r<=?";
			
			st = conn.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(args[0]));
			st.setInt(2, Integer.parseInt(args[1]));
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				int r = rs.getInt("r");
				String first_name = rs.getString("first_name");
				double salary = rs.getDouble("salary");
				System.out.println(String.format("%-3d|%-20s|%-12.2f",
						r, first_name, salary));
			}
			
			
		} catch(ClassNotFoundException e) {
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}
```

* 순서 추출하는 방법 ( 이 중 하나를 sql 문장에 사용 )

```sql
1) rownum을 이용
select r, salary
from (select rownum r, salary
     from(select * from employees order by salary desc)
     )
where r>= 11 and r <= 20;

2) row_number()이용
select r, salary
from (select row_number() over(order by salary desc) as r, salary
     from employees)
where r between 11 and 20;

3) rank() 이용
select r, salary
from (select rank() over(order by salary desc) as r, salary
     from employees)
where r between 11 and 20;

4) dense_rank() 이용
select r, salary
from (select dense_rank() over(order by salary desc) as r, salary
     from employees)
where r <= 10;
```

