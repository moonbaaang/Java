package generic1;

class Apple{
	String origin = "대구";
}
class Paper{
	String size = "A4";
}
class Box<T, K>{ //<Type>을 자동으로 해준다. 쓰는타입의 이름은 임의로 정해도 되나 통일시킨다.
	T t1;
	K k1;
	Box(T t1, K k1){ //모든 객체가 올 수 있다는 표현
		this.t1 = t1;
		this.k1 = k1;
	}
	public T getT1() {
		return t1;
	}
	public K getK1() {
		return k1;
	}
	public void setT1(T t1) {
		this.t1 = t1;
	}
	public void setK1(K k1) {
		this.k1 = k1;
	}
}

class BoxManager{ //이 클래스는 제너릭이 아님
	public <P1, P2> Box<P1, P2> test(P1 a, P2 p) { //<P1, P2>Box >> 전달하는 파라미터이다 라고 알려줌. 제너릭 메소드. (첫번째 요소, 두번째 요소)를 반드시 넘기라는 표현
		//Box<Apple, Paper> box2 = new Box<Apple, Paper>(a, p); 
		Box<P1, P2> box2 = new Box<P1, P2>(a, p);
		return box2;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		Apple a = new Apple();
		Paper p = new Paper();
		Box<Apple, Paper> box = new Box<Apple, Paper>(a, p);

		System.out.println(box.getT1().origin); // <T> 지정으로 형변환 없이 간단하게 사용
		System.out.println(box.getK1().size);
		
		BoxManager manager = new BoxManager();
		Box<Apple, Paper> box2 = manager.test(a, p);
		System.out.println(box2.getT1().origin); 
		System.out.println(box2.getK1().size);
	}
}
