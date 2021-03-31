package day4;

class Person{
	//이름 나이 국적
	String name;
	int age;
	static final String nation="대한민국"; //기본
}

public class StaticTest {

	public static void main(String[] args) {
		System.out.println(Person.nation); 
		// 객체 생성 이전 사용하고싶을때, 클래스명.static변수
		Person p1 = new Person();
		p1.name="박민국";
		p1.age = 20;
//		p1.nation = "미국"; // final 이 붙지 않으면 미국으로 변경시 모두 변경됨
		System.out.println(p1.name+":"+p1.age+":"+p1.nation);
		Person p2 = new Person();
		p2.name="김대한";
		p2.age = 30;
		//p2.nation = "미국";
		System.out.println(p2.name+":"+p2.age+":"+p2.nation);

	}
}