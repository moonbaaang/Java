package day4;

class Employee{//회사원 객체를 표현할 클래스
	// 사번 이름 직급 부서 변수
// 생성자는 객체를 만들기 위해 반드시 필요한데 자바에서는 자동으로 기본 생성자가 내장되어있음
	// default Constructor 존재. 아래와 같음
	Employee(String id, String name){
		// 50개 문장이 있는 경우
		this.id = id; // id=id 이면 매개변수? 멤버변수? 구분 안됨 멤버변수에 this를 붙임
		this.name = name;
	}
	Employee(String id){
		this(id,"none"); // 위의 생성자를 호출, 아래 결과와 같음
		//this.id = id;
		//name = "none"; // this.name 이라고 해도 됨 (변수 이름이 구분됨)
	}
	Employee(){
		this("---","none");
	} // 기본 생성자는 없는 상태이고 만든 생성자로 overloading한 상태
		
	String id;
	String name;
	String title;
	String dept;
	
	//메소드
	void work(){
		System.out.println(name+" 사원이 "+dept+" 부서에서 일한다.");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		Employee e1 = new Employee("100", "이사원"); 
		// 생성자 호출되어 객체가 만들어진 후 변수나 메서드 호출하여 사용
		Employee e2 = new Employee("200");
		Employee e3 = new Employee();
		System.out.println(e1.id+":"+e1.name);
		System.out.println(e2.id+":"+e2.name);
		System.out.println(e3.id+":"+e3.name);
		e1.work();
	}

}
