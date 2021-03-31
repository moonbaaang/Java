package io;

import java.util.ArrayList;
import java.util.Scanner;

class Employeetest{
	int id;
	String name;
	double salary;
	Employeetest(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String toString() {
		return id+"|"+name+"|"+salary;
	}
	
}

public class MenuTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		Employeetest e = null; 
		ArrayList<Employeetest> list = new ArrayList<Employeetest>();
		//파일이나 db에 데이터를 영구적으로 저장하여 보존(컴퓨터 전원이 꺼져도 O)
		
		while(true) {
			System.out.println("===다음과 같은 메뉴 이용 가능합니다===");
			System.out.println("1. 사원등록");
			System.out.println("2. 사원정보조회");
			System.out.println("3. 사원정보수정");
			System.out.println("4. 사원탈퇴");
			System.out.println("5. 프로그램 종료");
			System.out.println("\"");
			System.out.println("번호입력 :");
			int menu = key.nextInt();
			if(menu == 1) {
				System.out.println("  사번 입력  : ");
				int id = key.nextInt();
				System.out.println("  이름 입력  : ");
				String name = key.next();
				System.out.println("  급여 입력  : ");
				double salary = key.nextDouble();
				e = new Employeetest(id, name, salary);
				//ArrayList를 저장하고 등록사원을 ArrayList 가장 끝에 저장
				list.add(e);
				System.out.println(list.size() + " 명의 사원등록을 마쳤습니다.");
			} else if(menu == 2) {
				System.out.println("사원정보조회를 선택하셨습니다.");
				for (Employeetest em : list) {
					System.out.println(em);
				}
			} else if(menu == 3) {
				System.out.println("사원정보수정를 선택하셨습니다.");
				// 수정 사번 입력 : 100
				// 수정항목 입력 : name 박수정 > 이름을 박수정으로 변경
				//			  salary 3000 > 현재급여 3000으로 변경
			} else if(menu == 4) {
				System.out.println("사원탈퇴를 선택하셨습니다.");
				// 탈퇴 사번 입력 : 100
				// 100 사번을 찾아서 list에서 삭제함
			} else if(menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("해당 기능의 메뉴는 존재하지 않습니다.");
			}
		}
	}

}
