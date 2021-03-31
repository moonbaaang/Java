package day8;

class Outer2{
	int outervar = 10; // 외부클래스 멤버변수 nonstatic
	static int outervar2 = 20; //static
	String name = "Outer2";
	class Inner1{ // non-static(=인스턴스) 멤버 중첩 클래스
		String name = "Inner";
		void m() {
			String name = "m메소드";
			System.out.println("중첩클래스 메소드 실행1");
			System.out.println(outervar);
			System.out.println(outervar2);
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Outer2.this.name);
		}
	}
	static class Inner2{ //Inner 클래스 앞에는 변수를 사용하듯이 static modifier를 사용가능하다./ static 멤버 중첩 클래스
		void m2() {
			System.out.println("중첩클래스 메소드 실행2");
			//System.out.println(outervar); 사용 불가능 Why? static은 메모리에 먼저 저장되기 때문(만들어지는 시기가 다르다.)
			System.out.println(outervar2);
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
public class InnerTest2 {
	// 1>main 실행 이전 static(변수, 내부클래스, 메소드) 는 먼저 메모리에 저장됨
	// 2> new Outer2() 실행 non-static(변수, 내부클래스, 메소드) apahfl wjwkd

	public static void main(String[] args) {
		//Outer o = new Outer();
		//Outer.Inner i = o.new Inner();
		Outer2.Inner1 i1 = new Outer2().new Inner1(); //static이 아니라면 
		i1.m();
		
		Outer2.Inner2 i2 = new Outer2.Inner2(); // static 이라면
		i2.m2();
		
		Outer2 o = new Outer2();
		o.test();
	}

}
