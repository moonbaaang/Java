package day2;

public class ForTest {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		for(i = 1; i <=10; i++) {
			if(i==5) {continue;}
			sum = sum+i;
			System.out.println(i+" 값까지의 정수 총합 = "+sum);
		}
		System.out.println((i-1)+" 값 까지의 정수 총합 = "+sum);
		
//		for(int i = 1; i <=10;i++) {
	//		System.out.println((int)(Math.random()*101)); 
		}

	}

