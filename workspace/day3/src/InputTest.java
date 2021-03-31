//main - 클래스를 시작해주는 메소드 - entry point method > 자동으로 호출됨
import java.lang.Integer;


public class InputTest {
	public static void main(String args[]) {
/*
		args = new String[3];
		args[0] = "자바";
		args[1] = "program";
		args[2] = "과정";
*/
		for(int i= 0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println(args[0]+args[1]);
		int first = Integer.parseInt("args[0]"); // "100"이라는 값을 정수로 변환
		int second = Integer.parseInt("args[1]");
		System.out.println(first+second);
	}
}
// run InputTest --> run inputTest.main()  자동실행
// run InputTest 입력변수 전달 --> run InputTest.main() 자동실행
