package nongeneric;

class Apple{
	String origin = "대구";
}

class Paper{
	String size = "A4";
}

class Box<T>{ //<Type>을 자동으로 해준다.
	T o;
	Box(T o){ //모든 객체가 올 수 있다는 표현
		this.o = o;
	}
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
	
}
public class GenericTest {

	public static void main(String[] args) {
		Apple a = new Apple();
		Paper p = new Paper();
		Box<Apple> appleBox = new Box<Apple>(a);
		Box<Paper> paperBox = new Box<Paper>(p);
		//if(appleBox.getO() instanceof Apple) {
		//System.out.println(((Apple)appleBox.getO()).origin);
		//}
		System.out.println(appleBox.getO().origin); // <T> 지정으로 형변환 없이 간단하게 사용
		//if(paperBox.getO() instanceof Paper) {
		//System.out.println(((Paper)paperBox.getO()).size);
		//}
		System.out.println(paperBox.getO().size);
	}
}
