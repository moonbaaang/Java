# JDBC Connection

> Oracle과 JDBC를 연결하는 코드

* 연결 순서는 다음과 같다.

  1) JDBC driver (자바클래스) 등록 메모리 로드

  2) DB연결 - DB종류마다 서로 다른 라이브러리 호출

  3) SQL 전송

  4) SQL 결과 검색

  5) DB연결 해제

  * 본 과정에서는 3, 4번 과정을 제외한 나머지 연결 과정을 나열했다.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class pr_ConnectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
			// 프로젝트 작업 시 실제 @ip address가 필요
			
			System.out.println("DB 연결 성공");
            
		} catch(ClassNotFoundException e) { // name에 오타, ojdbc 세팅이 안되어있을 때
			System.out.println("Check driver setting!");
		} catch(SQLException e) {
			System.out.println("Check DB connection info");
		} finally {
			try {
				conn.close(); // 반드시 처리해야하는 문장
				System.out.println("DB 연결 해제");
			} catch(SQLException e) {}
		}
	} // main end
}

```

