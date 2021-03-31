package edu;


class Employee{
	int id;
	String name;
	String salary;
	String pw = "Employee";
	public void printEmp() {
		System.out.println(id+":"+name+":"+salary);

	}
}
class Manager extends Employee{
	String jobOfManage; // 관리 업무
	int cntOfSub; // 부하직원수
	String pw = "Manager"; // manager 에는 pw가 상속을 받아 두가지가 나옴
	// Employee 상속 그대로 사용, 또는 변경 재정의
	// 이름 매개변수, 리턴타입, modifier 동일하거나 modifier 더 넓을 수 있다.
	//@override // 자바시스템에 알려줌 ( 오버라이딩 규칙에 어긋나는지 알려준다.)
	public void printEmp() {	
		super.printEmp();
		//System.out.println(id+":"+name+":"+salary);
		System.out.println(jobOfManage+":"+cntOfSub);
	}
	void test() {
		String pw = "test메소드";
		System.out.println(pw);
		System.out.println(this.pw);
		System.out.println(super.pw);
	}
}
public class InheritanceTest {

	public static void main(String[] args) {
		Manager m = new Manager(); // 상속받은 내용까지 사용가능
		m.id = 12345;
		m.name = "김부각";
		m.jobOfManage = "it직종 관리";
		m.cntOfSub = 10;
		System.out.println(m.id+":"+m.name+":"+m.jobOfManage+":"+m.cntOfSub);
		m.test();
		m.printEmp(); //Manage 에서 재정의
	}

}

class As {
	Math.random();
}