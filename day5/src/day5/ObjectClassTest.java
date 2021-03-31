package day5;

public class ObjectClassTest {

	public static void main(String[] args) {
		MyObject o1 = new MyObject("java");
		MyObject o2 = new MyObject("java");
		//리턴 - 패키지명.클래스명@16진수주소값
		//객체는 자동 먼저 호출결과를 출력
		//메소드 오버라이딩 하면 다른값 재정의 가능
		System.out.println(o1);
		System.out.println(o1.toString());
		System.out.println(o2);
		System.out.println(o2.toString());
		
		if(o1==o2) { // "==" 기본+참조(실제값+주소값) - 연산자 오버라이딩X
			System.out.println("o1==o2 is true");
		}
		if(o1.equals(o2)) { // 메소드 : 참조(주소값) - 메서드오버라이딩O
			System.out.println("o1.equals(o2) is true");
			// 메소드 : 참조(주소값) : 메소드 오버라이딩 이전
			// 전달매개변수 MyObject타입이고 전달 매개변수값이 동일하면 true메소드 오버라이딩 이후
		}
	}
}
	
class MyObject /*extends Object*/{
	String msg; //멤버변수 msg에 저장됨
	MyObject(String msg){
		this.msg = msg;
	}
		//toString(), equals() 그대로 상속포함

	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
//		MyObject o2 = new MyObject();
//		Object obj = o2;
		
		if(obj instanceof MyObject) {// obj가 MyObject로 바뀔수 있는지 검사
			String me = this.toString();
			String other = obj.toString();
			if(me.equals(other)) { // String equals 메소드 - 문자열 내용 비교
				return true;				
			} else { 
				return false;
		} 
		}else {
			return false;
		}
	}
	
	
}

