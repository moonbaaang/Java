package day3;

class MyObject{
	int a = 10;
}

class Call{
	void add(int i) {  // add 메서드 , return 값이 없으므로 void 형 사용
		System.out.println(i++);
		// i = 10이라 가정 시 10 출력 후 i = 11
	}
	void addObject(MyObject mo) { // 참조형 변수
		MyObject mo_copy = mo;
		System.out.println(mo_copy.a++);
	}
}

public class CallByValueTest {

	public static void main(String[] args) {
		Call c = new Call();
		int j = 10;
		c.add(j);
		System.out.println("c.add(j) 호출 후의 J = "+j);
		MyObject obj = new MyObject();
		c.addObject(obj); //mo로 전달이 됨
		System.out.println("c.addObject(obj) 호출 후의 obj.a = "+obj.a);
	}

}
