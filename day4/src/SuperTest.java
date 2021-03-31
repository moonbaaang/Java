
class A{// extend Object
	int i ;
	A(String s){ //super(); Object() 생성자 호출
		i = 10;
		System.out.println("A 생성자 호출");
	}
}

class B extends A{
	int j;
	B(){ 
		super("String value");// (A생성자 호출)
		j=100;
		System.out.println("B 생성자 호출");
	}
}
public class SuperTest {

	public static void main(String[] args) {
		B b1 = new B();
		System.out.println(b1.i);
		System.out.println(b1.j);

	}

}
