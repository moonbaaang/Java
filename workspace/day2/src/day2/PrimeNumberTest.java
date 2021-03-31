package day2;

public class PrimeNumberTest {

	public static void main(String[] args) {
		// prime number = 소수
		int su = 30; //2-su 숫자가 모두 소수인지 검사
		// 13 % 1 ==0 , 13%13 ==0 
		// 13 % ?? = ? > 0은 아니다.
		// 1-13 까지 반복
		// 나눗셈 - 나머지 조사 0 인 경우가 2개이면 소수
		
		/* 선생님 풀이
		 * for(int i=2; i<su;i++) {
		 * 	int cnt = 0;
		 * 	for (int j=1;j<=i;j++) {
		 * 		if(j%i ==0) {cnt++;}
		 * } 
		 *  if (cnt ==2) {
		 *  	system.out.println(i + " 는 소수이다.");
		 * }
		 *   else {
		 *   	system.out.println(i + " 는 소수가 아니다.");
		 *   }
		 * }
		 * 
		 */
		
		
		int cnt = 0; // 내 풀이
		for (int i = 2; i<=su;i++) {
			cnt = 0;
			for (int j=1; j<=i; j++) {
				if(i%j ==0) { cnt++;}	
			} if(cnt==2) {
				System.out.println(i+" 는 소수이다.");
			} else {
				System.out.println(i+" 는 소수가 아니다.");
			} 
			}
		
	}
}

/*
		for(int i = 2; i <=20; i++){
			for (int j = 1; j <=i; j++){
				if (i % j == 0) {
					count++;
				}  if (count ==2) {
					System.out.println(i+"는 소수입니다.");
				}
			}
		}
*/