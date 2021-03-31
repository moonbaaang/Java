package menuExample;

import java.io.IOException;
import java.io.InputStream;

class Employee{
	int id;
	String name;
	double salary;
	Employee(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public double getSalary() { return salary; }
	public void setSalary(double salary) { this.salary = salary; }
}
public class MenuExample {
	public static void main(String[] args) {
		System.out.println("===다음과 같은 메뉴 이용 가능합니다===");
		System.out.println("1. 사원등록");
		System.out.println("2. 사원정보조회");
		System.out.println("3. 사원정보수정");
		System.out.println("4. 사원탈퇴");
		System.out.println("5. 프로그램 종료");
		System.out.println("\"");
		System.out.println("번호입력 :");
		
		try {
			InputStream is= System.in; // System.in (키보드)
			byte b[] = new byte[100];
			int cnt = is.read(b); // 키보드 1바이트 입력, b배열 저장, cnt입력 개수
			String inputString = new String(b, 0, cnt); // 한 문자를 2바이트씩
			
			System.out.print(inputString);
		} catch(IOException e) {
			e.printStackTrace();
			}

	}

}
