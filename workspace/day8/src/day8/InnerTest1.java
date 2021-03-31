package day8;

class Outer{
	class Inner1{ // non-static(=인스턴스) 멤버 중첩 클래스
		void m() {
			System.out.println("중첩클래스 메소드 실행1");
		}
	}
	static class Inner2{ //Inner 클래스 앞에는 변수를 사용하듯이 static modifier를 사용가능하다./ static 멤버 중첩 클래스
		void m2() {
			System.out.println("중첩클래스 메소드 실행2");
		}
	}
	void test() { //지역 중첩 클래스
		class Inner3{
			void m3() {
				System.out.println("중첩클래스 메소드 실행3");
			}
		}
		new Inner3().m3(); // 메서드 호출을 test() 클래스 내부에서 하여 inner3 을 호출
	} 
}
public class InnerTest1 {

	public static void main(String[] args) {
		//Outer o = new Outer();
		//Outer.Inner i = o.new Inner();
		Outer.Inner1 i1 = new Outer().new Inner1(); //static이 아니라면 
		i1.m();
		
		Outer.Inner2 i2 = new Outer.Inner2(); // static 이라면
		i2.m2();
		
		Outer o = new Outer();
		o.test();
	}

}
