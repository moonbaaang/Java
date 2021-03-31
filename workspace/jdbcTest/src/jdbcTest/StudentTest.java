package jdbcTest;

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
		
		dao.insertStudent(dto); // 1명 입력
		
		ArrayList<StudentDTO> list = dao.printAllStudent();
		
		for(StudentDTO one : list) {
			System.out.println
			(String.format("%-3d %-10s %10s %-10s %-20s", 
				one.getNo(),one.getName(),one.getDet(),one.getAddr(),one.getTel()));
		}
		
	}

}

