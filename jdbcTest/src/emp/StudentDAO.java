package emp;

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
