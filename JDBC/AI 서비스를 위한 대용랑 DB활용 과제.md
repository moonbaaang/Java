# AI 서비스를 위한 대용랑 DB활용 과제

##### 1. 다음과 같은 구조의 테이블에 2개의 레코드를 저장하는 SQL을 작성하세요.

 테이블 명 : Student

| 필드명 | 데이터타입 | 의미     | 비고                  |
| ------ | ---------- | -------- | --------------------- |
| No     | int        | 학번     | primary key, not null |
| name   | char(10)   | 성명     |                       |
| det    | char(20)   | 전공     |                       |
| addr   | char(80)   | 주소     |                       |
| tel    | char(20)   | 전화번호 |                       |

레코드

1 홍길동 국문학과 서울 010-1111-111

2 고길동 수학과  인천 010-2222-2222

```sql
insert into Student values(1, '홍길동', '국문학과', '서울', '010-1111-1111');
insert into Student values(2, '고길동', '수학과', '인천', '010-2222-2222');
```

</br>

##### 2. 실습 1에 기반하여 다음과 같은 요구사항을 만족하도록 클래스를 작성하세요

* StudentDAO

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO {
	public void insertStudent(StudentDTO studentDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracl:thin:@127.0.0.1:1521:xe","test","test");
			System.out.println("db연결 성공");
			
			String sql = "insert into student"
					+ " values(?, ?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
		
			studentDTO.setNo(3);
			studentDTO.setName("나길동");
			studentDTO.setDet("영문학과");
			studentDTO.setAddr("제주");
			studentDTO.setTel("010-3333-3333");
			
			ps.setInt(1, studentDTO.getNo());
			ps.setString(2, studentDTO.getName());
			ps.setString(3, studentDTO.getDet());
			ps.setString(4, studentDTO.getAddr());
			ps.setString(5, studentDTO.getTel());			
			
			int insertrow = ps.executeUpdate();
			System.out.println(insertrow+"개의 행 삽입");
			

		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) {
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
				System.out.println("db연결 해제 성공");
			} catch(SQLException e) {e.printStackTrace();} // 예외처리 한번 더 필요
		}//finally end	
	}
	
	
	public ArrayList<StudentDTO> printAllStudent() {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracl:thin:@127.0.0.1:1521:xe","test","test");
		
			String SQL = "select * from Student order by no";
			pt = conn.prepareStatement(SQL);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setDet(rs.getString("det"));
				dto.setAddr(rs.getNString("addr"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 세팅 확인하세요");
		} catch(SQLException e) {
			System.out.println("DB 연결정보 확인하세요");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pt.close();
				conn.close();
				System.out.println("db연결 해제");
			} catch(SQLException e) {e.printStackTrace();}
		} return list;
	} 
	
}
```

* StudentDTO

```sql
public class StudentDTO {
	int no;
	String name, det, addr, tel;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDet() {
		return det;
	}
	public void setDet(String det) {
		this.det = det;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
```

* StudentTest

```sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import emp.StudentDAO;
import emp.StudentDTO;

public class StudentTest {
	public static void main(String[] args) {
		StudentDTO dto = new StudentDTO();
		StudentDAO dao = new StudentDAO();
		
		dao.insertStudent(dto);
		
		ArrayList<StudentDTO> list = dao.printAllStudent();
		for(StudentDTO one : list) {
			System.out.println
			(String.format("%-3d %-10s %10s %-10s %-20s", 
				one.getNo(),one.getName(),one.getDet(),one.getAddr(),one.getTel()));
		}
		
	}

}
```

