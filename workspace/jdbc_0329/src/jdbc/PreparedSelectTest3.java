package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import emp.EmployeeDAO;
import emp.EmployeeDTO;

import java.sql.Connection;

public class PreparedSelectTest3 {
// 오라클 자동시작 - ojdbc6.jar 설치, 이클립스 세팅
	public static void main(String[] args) { // String... args 비정형 매개변수
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.getEmployees(args[0], args[1]);
		// 1 5 >>> 1페이지 데이터(한페이지당 5개씩 출력)
		// 2 5 : 6 ~ 10
		// 3 6 : 13 ~ 18
		
		for (EmployeeDTO dto : list) {
			System.out.println(dto.getFirst_name()+" | "+dto.getSalary());
		}
	} //main
}
