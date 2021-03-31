package template;

public class Controller {
	static private Controller con = new Controller();
	private Controller(){} 
	public static Controller getInstance() {
		return con;
	}
	
	//사원등록 제어 부분
	void insert(int id, String name, double salary) {
		EmployeeVO e = new EmployeeVO(id, name, salary); //임시저장
		EmployeeDAO dao = new EmployeeDAO();
		dao.insert(e);
	}
	
	void getAll(){
		EmployeeDAO 생성
	}
}

//Controller c = Controller.getInstance(); // 싱글톤 패턴
/* 싱글톤 생성자 private , 변수에 private 사용할 것, public static객체를 만들어 변수를 return 
 * 
 */