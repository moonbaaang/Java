package day5;
// > 1 다중상속 / 2 여러 서로 클래스 공통 메소드 정의 스펙 = abstract클래스
class StudentTeacher implements Student, Teacher{
	//String name = "학생";
	//String name = "교수";
	String name = "조교";
	public void study() { //인터페이스에 public이 붙어있지 않아도 public붙여야함
		System.out.println(Student.name);
		System.out.println(Teacher.name);
		//super.name 은 불가능. 상속받은 클래스가 없음.
		//상위 "객체" > 따라서 super는 Object가 되고 name이란 변수가 선언되지않음
		//인터페이스의 변수는 static이므로 직접 인터페이스명.변수명 으로 사용하면된다.
		System.out.println("학생 - 공부하다");
	}

	@Override //source 메뉴에 자동 만들어주는 툴 존재
	public void teach() {
		System.out.println("선생님 - 가르치다");
		
	}

	@Override
	public void lunch() {
		System.out.println("학생과 선생님 - 점심먹다");
		
	}
}

class ITTeacher implements Teacher{

	@Override
	public void teach() {
		System.out.println("it를 가르치다");
		
	}

	@Override
	public void lunch() {
		System.out.println("12시에 점심먹다");
		
	}
	
}

public class InterfaceTest {
	


	public static void main(String[] args) {
	/*	StudentTeacher st = new StudentTeacher();
		st.study();
		st.lunch();
		st.teach(); */
	//	Student st = new StudentTeacher();
	//	st.study();
	//	st.lunch();
	//	st.teach(); >> Student 인터페이스에 teach가 없음.
		
	/*	Teacher st = new StudentTeacher();
		//st.study(); >> Teacher 인터페이스에 study없음
		st.lunch();
		st.teach();
		
		System.out.println(st.name); // 매개변수로 그냥 name은 불가능
	*/
		Teacher [] t = new Teacher[2];
		t[0] = new StudentTeacher();
		t[1] = new ITTeacher(); // teachr 타입으로 형변환이됨.
		t[0].teach();
		t[0].lunch();
		t[1].teach();
		t[1].lunch();
		
		for (int i = 0; i<t.length;i++) {
			if(t[i] instanceof StudentTeacher) {//t[i]가 StudentTeacher로 바뀔수 있는지 검사
			StudentTeacher st = (StudentTeacher)t[i];
			st.study();
			}
		}
		
		StudentTeacher st = (StudentTeacher)t[0];
		st.study();
	}

}
