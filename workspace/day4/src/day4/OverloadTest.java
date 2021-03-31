package day4;

class Adding{
	public int add(int i, int j) {
		return i+j;
	}
	public double add(double i, double j) {
		return i+j;
	}
	public String add(String i, String j) {
		return i+j; // 두 문자열을 하나로 결합
	}
}

public class OverloadTest {
	public static void main(String[] args) {
		String s1 = "100";
		int dec = java.lang.Integer.parseInt(s1);
		int bin = java.lang.Integer.parseInt(s1, 16);
		System.out.println(dec);
		System.out.println(bin);
		Adding a = new Adding();
		String r1 = a.add("java", "program");
		int r2 = a.add(10, 20);
		double r3 = a.add(3.14, 2.0);
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
}
/* 추정해보기
 * class Integer{
 * public int parseInt(String s){
 * s 를 정수로 변경 기능
 * return s 를 정수로 변경
 * }
 * public int parseInt(String s, int r){
 * return r 진수로 변경
 * }
 * } >>>> 같은 이름의 메소드를 정의할 수 있으나 매개변수는 다르게 지정하여야함
 * 1개 메소드 이름이 2개 기능을 구현하는 것과 유사
 * 메소드 overloading
 * >> 매개변수 개수, 타입, 순서 중 1개 이상 다르게 정의 
 */ 
