package day2;

public class StatTest {

	public static void main(String[] args) {
		// 5*5 사각형 모양의 별표 출력
		/*
		for (int i =1;i<=5;i++) {
			for (int j=1;j<=5;j++) {
			System.out.print("*");
			}
			System.out.println();
		} */
		
/*		for (int i=1;i<=5;i++) {
			for (int j=1;j<=i;j++) {
				System.out.print("*");
			} System.out.println();
		} */
		
		char c = 'a';

		for(int i =1;i<=5;i++) {
			for(int j =c;j<c+i;j++) {
				System.out.print((char)j);
			}
			c=(char)(c+i);
			System.out.println();
		}
		
		
		
		
		// 내가 작성한 코드
		/*
		char c = 'a';
		for (int i=1;i<=5;i++) {
			for (int j=1;j<=i;j++) {
				System.out.print(c);
				c++;
			} System.out.println();
		}
		*/ 
	}
}
