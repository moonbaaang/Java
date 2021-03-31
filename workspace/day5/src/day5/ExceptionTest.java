package day5;

public class ExceptionTest {

	public static void main(String[] args) {
		// 2개 이상 명령행 매개변수 입력, 정수 변경이 가능한 값, 0 제외
		// 예외가 발생할 가능성이 있는 문장 try
		try {
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		System.out.println(i/j);
		}
		catch(ArithmeticException e) {
			System.out.println("0을 입력하면 나누기가 불가능합니다.");
		}
		finally {
			System.out.println("반드시실행하는 문장입니다.");
			//파일 입출력 - 종료 명시 , db연결 - 연결해제명시 , 네트워크 - 네트워크연결해제 명시문장
			
		//		catch(Exception e) {
//			System.out.println("모든예외 동일 처리");
			//모든 예외 동일 처리
			// class ArithmeticException extends Exception
			// 자바의 예외 클래스는 모두 Exception을 상속받음
			// Exception e = new ArithmeticException();
		}

		
/*		catch(ArithmeticException e) {
			//j = 100;
			System.out.println("0을 입력하면 나누기 불가능");
			e.printStackTrace(); //예외발생라인 추적정보
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e) {
			System.out.println("정수로 변환할 수 없는 값입니다.");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("2개 이상의 값을 입력하시오.");
		}
*/
		
		System.out.println("main 종료");
	}

}
