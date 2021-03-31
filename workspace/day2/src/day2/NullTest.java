package day2;

public class NullTest {

	public static void main(String[] args) {
		String s1 = null;
		System.out.println(s1);
		if (s1!=null) {
		System.out.println(s1.toUpperCase());
		}
		//char > 1개 문자 (단일 문자 표현) / String > 여러 문자 표현
		String sa = "java";
		String sb = "java";
		String sc = new String("java");
		String sd = new String("java");
		if (sa == sb) {
			System.out.println("sa == sb 입니다.");
		}
		if (sb == sc) {
			System.out.println("sb == sc 입니다.");
		} 
		if (sc == sd) {
			System.out.println("sc == sd 입니다.");
		}
		// 참조형 변수 == 동등성 비교 > 주소값 동일 비교
		// String.equls() >> 동등성 비교 > 문자열 내용 동일 비교
		
		if (sa.equals(sb)) {
			System.out.println("equals사용 sa == sb 입니다.");
		}
		if (sb.equals(sc)) {
			System.out.println("equals사용 sb == sc 입니다.");
		} 
		if (sc.equals(sd)) {
			System.out.println("equals사용 sc == sd 입니다.");
		}
	}
}