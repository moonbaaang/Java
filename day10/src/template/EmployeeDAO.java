package template;

import java.io.FileWriter;

public class EmployeeDAO {
	void insert(EmployeeVO vo) {
		try {
			FileWriter fw = new FileWriter("employee.txt", true);
			fw.write(vo.toString()+"\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ArrayList getAll() 
		1 라인 > EmployeeVO > ArrayList 리턴
	}
}
