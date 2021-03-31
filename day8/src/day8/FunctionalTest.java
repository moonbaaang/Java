package day8;

@FunctionalInterface
interface Math{
	public int calc(int first, int second);
	//public double calc2(double f, double s); > 인터페이스에 2개 이상 정의 불가능
}

@FunctionalInterface
interface A1{
	int ma();
}

@FunctionalInterface
interface B{
	int mb(int i);
}

class C1{
	static int mc1(int i, int j) { return i/j;}
	int mc2(int i, int j) {return i%j;}
}
/*
class A1 implements Math{
	public int calc(int first, int second) {return first*second;}
}
class B implements Math{
	public int calc(int first, int second) {return first + second;}
}
*/
public class FunctionalTest {
	String name = "멤버변수";
	public static void main(String args[]) {
		
		C1.mc1(10, 2);
		C1 c = new C1(); // static이 아니기에 이렇게 사용
		c.mc2(10,2);
		
		
		String name = "메인지역변수";
/*			Math m = new Math() {
				public int calc(int first, int second) {return first/ second;}
		};
		System.out.println(m.calc(10, 2));
		System.out.println(new A1().calc(10,2));
		System.out.println(new B().calc(10, 2));

		Math m = (a,b)->a*b;
		System.out.println(m.calc(10, 2));
		
		Math m2 = (i,j)->i-j;
		System.out.println(m2.calc(10, 2));

		Math m3 = (i,j)->i+j;
		System.out.println(m3.calc(10, 2));
		
		Math m4 = (i,j)->i/j;
		System.out.println(m4.calc(10, 2));
*/		
		//Math m5 = (i,j)->C1.mc1(i, j); //람다식의 매개변수를 외부클래스 메소드 매개변수로 전달
		Math m5 = C1::mc1; // 동일한 표현이다. 클래스명::static 메소드명
		System.out.println(m5.calc(10, 2));
		
		
		C1 c1 = new C1();
		Math m6 = c1::mc2;
		//Math m6 = new C1()::mc2; //non-static메소드 사용 방법
		System.out.println(m6.calc(10,2));
		
/*		A1 a1 =()->1;
		System.out.println(a1.ma());
		
		B b1 = (a)-> { 
			String name2 = "람다";
			System.out.println("람다식 실행");
			System.out.println(name);
			// static 변수 > 클래스명.static변수
			// non static 변수 > new 클래스명().non-static변수
			System.out.println(new FunctionalTest().name);
			return a*a; 
		};*/
		//System.out.println(b1.mb(10));

	}
}
