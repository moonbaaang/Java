package day2;

public class SwitchCase {

	public static void main(String[] args) {
		// 1-12 난수 발생 - 월에 따른 계절 알려주기
		// 난수가 3,4,5 일 때 계절은 봄입니다.
		// 6,7,8 일 때 계절은 여름입니다.
		// 9,10,11 일때 계절은 가을입니다.
		// 나머지 일 때 겨울입니다.
		int month = (int)(Math.random()*12)+1;
		System.out.println(month+"월 :");
		
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("계절은 봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("계절은 여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("계절은 가을입니다.");
			break;
		default : 
			System.out.println("계절은 겨울입니다.");
			
		}
	}

}
