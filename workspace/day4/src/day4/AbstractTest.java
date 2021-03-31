package day4;

abstract class Shape{
	abstract void area();
}

class Circle extends Shape{
	int r;
	final static double pi = 3.14;
	Circle(int r){
		this.r = r;
	}
	void area(){
		System.out.println("반지름 = "+r+" 인 원의 면적 = "+r*r*pi);
	}
}

public class AbstractTest {

	public static void main(String[] args) {
		Circle r = new Circle(5);
		r.area();

	}

}
