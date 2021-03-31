package jdbc;

import java.util.ArrayList;

import emp.EmployeeDAO;
import emp.EmployeeDTO;

public class PreparedSelectTest3 {
//1. 오라클 자동 시작 2.ojdbc6.jar  설치-이클립스 세팅 (jdk경로\jre\lib\ext\ojdbc6.jar)
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		ArrayList<EmployeeDTO> list = dao.getEmployees(args[0], args[1]);
		// 1 5 : 1 ~ 5 ---> 1페이지 데이터(한페이지당 5개씩 출력)
		// 
		// 2 5 : 6 ~ 10
		// 3 6 :  13 ~ 18
		for(EmployeeDTO dto : list) {
			System.out.println(dto.getFirst_name() + "|" + dto.getSalary());
		}
	}//main 

}
