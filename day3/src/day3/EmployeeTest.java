package day3;

class Employee{//회사원 객체를 표현할 클래스
	// 사번 이름 직급 부서 변수
	String id;
	String name;
	String title;
	String dept;
	
	//메소드
	String work(){
		System.out.println(name+" 사원이 "+dept+" 부서에서 일한다.");
		return "이달의 급여처리 업무 완료";
	}
}
public class EmployeeTest {

	public static void main(String[] args) {
		// 실행할 문장은 모두 main 메소드 안에 작성
		Employee e1 = new Employee();
		e1.id="100";
		e1.name = "박대리";
		e1.title = "대리";
		e1.dept = "인사부";
		System.out.println(e1.id + ":"+e1.name+":"+e1.title+":"+e1.dept);
		e1.work();
		String result1 = e1.work();
		System.out.println(result1);
		
		Employee e2 = new Employee();
		e2.id="200";
		e2.name = "최사원";
		e2.title = "사원";
		e2.dept = "개발부";
		System.out.println(e2.id + ":"+e2.name+":"+e2.title+":"+e2.dept);
		e2.work();
		String result2 = e2.work();
		System.out.println(result2);
		}

}


/*
	클래스 1개 + 여러개 = 하나의 파일
	public 선언 클래스명.java
	main 메소드를 가진 클래스명.java

*/