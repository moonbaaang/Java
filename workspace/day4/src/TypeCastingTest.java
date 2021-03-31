class Parent{
	int su1 = 10;
	void pr() {
		System.out.println(su1);
	}
	void mp() {
		System.out.println("Parent");
	}
}

class Child extends Parent{
	int su2 = 20;
	void pr() {
		System.out.println(su2); //overriding
	}
	void mc() {
		System.out.println("Child");
	}
}

public class TypeCastingTest {

	public static void main(String[] args) {
		Parent p1 = new Parent();
		Child c1 = new Child();
		Parent p2 = new Child(); //자동형변환 가능
		// Parent내의 메서드와 Child에서 오버라이딩 된 메서드만 사용가능
		System.out.println(p2.su1);
		//System.out.println(p2.su2); 불가능
		p2.mp();
		//p2.mc(); 불가능
		p2.pr();
		Child c2 = null;
		if(p2 instanceof Child) {
			System.out.println("test1");
			c2 = (Child)p2;
		}
		
		Parent p3 = new Parent();
//		Child c3 = (Child)p3;
		
		if(p3 instanceof Child) {
			System.out.println("test2");
			Child c3 = (Child)p3;
		}
		// Child객체로 만들어졌으나 Parent로 변경 됐었음
		// p2라고만 두면 변환 불가능, (Child) 형변환 연산자를 반드시 붙여주어야함
		System.out.println(c2.su2);
		c2.mc();
		
		Child te1 = (Child) p1;
		te1.mc();
		 // 얘는 왜 안될까?? Parent c3 이면 가능
		//Child c3 = new Parent(); // 상위클래스인 Parent를 Child로 형변환 불가능
		//Child c3 = (Child)new Parent(); // 명시적 형변환 불가능 처음부터 Parent여서 Child로 형변환 불가능
	}

}
