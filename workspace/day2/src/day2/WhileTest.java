package day2;

public class WhileTest {

	public static void main(String[] args) {
		// 0번 이상의 무한횟수 반복
		while (true) {
			int number = (int)(Math.random() * 50) + 1;
			System.out.println(number);
			//25일 때 중단
			if(number==25) {
				break;
				
			}
		}
		
	}

}
