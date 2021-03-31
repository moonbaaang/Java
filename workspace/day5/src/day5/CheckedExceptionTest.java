package day5;


public class CheckedExceptionTest {

	public static void main(String[] args) {
		try{
			Class.forName("A"); // A라는 이름의 클래스가 있는지 확인, 예외처리를 반드시 해야함
		}catch(ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		//args[0] - 정수 변경 - > 0 인지 ? 정상 사용
		//                  <=0 이면 ? 인위적 NumberFormatException
		int su = Integer.parseInt("-100");
		try {
		if(su<=0) {
			throw new NumberFormatException("소수를 만들기에 부적합한 수 입니다.");
			}
		} catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}	

}
