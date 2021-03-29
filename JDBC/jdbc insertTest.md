# jdbc insertTest

> DML중 insert에 대한 예제입니다.

* 이자바(emp_name) 사원을 사번 100(emp_id)인 사원과 같은 직급(title)로 변경

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pr_InsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("DB 연결 성공");
			
			String sql = 
					"update c_emp "
                	+ "set title = (select title from c_emp where emp_id = 100) "
					+ "where emp_name = '이자바'";
			
			st = conn.createStatement();
			int insertrow = st.executeUpdate(sql);
			System.out.println(insertrow+ "개의 행 삽입");
			
		} catch(ClassNotFoundException e) {
			// name에 오타, ojdbc 세팅이 안되어있을 때
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

* 대리 5000 > 이와같이 매개변수로 입력받아 c_emp 테이블 title이 대리인 직원의 현재 급여에 5000 인상

```java
package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class pr_InsertTest2 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
			System.out.println("DB 연결 성공");
			
			String sql = "update c_emp set salary=salary+"+args[1]
					+ " where title='"+args[0]+"'";
			st = conn.createStatement();
			int insertrow = st.executeUpdate(sql);
			
			System.out.println(insertrow+ "개의 행 삽입");
			
		} catch(ClassNotFoundException e) {
			// name에 오타, ojdbc 세팅이 안되어있을 때
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

* 이때 args[1]은 int타입인 5000이 들어가고, args[0]은 String타입인 '대리'가 들어간다.
  * java에서는 String타입은 큰따옴표 안에 넣어야하지만 oracle에서는 작은따옴표 안에 넣기 때문에 
    "'+args[0]+'"과 같이 표현한다.