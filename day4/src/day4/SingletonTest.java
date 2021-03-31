package day4;

//singleton - spring

class A{
	private static A a1 = new A(); // 변수
	private A(){ // 생성자
		System.out.println("A 생성자 호출");
	}
	static A getInstance(){ //메서드 public 을 붙이면 다른 패키지에서 사용가능
		return a1;  
		// static은 객체가 생성되기 이전부터 메모리에 저장하고 유지됨
		// a1에도 static이 붙어야한다.
	}
}


public class SingletonTest {

	public static void main(String[] args) {
		// A 객체를 강제로 하나만 만들도록 강제함.
		A.getInstance(); // static은 공유가 되기에 클래스 이름을 붙여 사용가능
		// A 타입 객체를 생성할 통로
		A.getInstance(); // 3 번 호출되지않음 한번 호출 후 공유됨
		A.getInstance();
		
		//		A a2 = new A();
		//		A a3 = a1; // 하나 만들어진 객체를 a2, a3가 같이 공유함

	}

}
