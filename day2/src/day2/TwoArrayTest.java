package day2;

public class TwoArrayTest {

	public static void main(String[] args) {
		// 3*4 이차원 배열
/*		int [] two_ar [] = new int [3][4];
		System.out.println(two_ar.length);
		System.out.println(two_ar[2].length);
		for(int i = 0; i<two_ar[0].length;i++) {//3
			for(int j=0; j <two_ar[0].length; j++){//4
				two_ar[i][j] = (i)*(i*j+1);
				System.out.print(two_ar[i][j]+"\t");
			} System.out.println();
		}
		
		*/
		
		// 3*? 이차원 배열 > 1차 배열 길이가 다르다
				int [] two_ar [] = new int [3][];
				System.out.println(two_ar.length);
//				System.out.println(two_ar[0].length); // two_ar[0] 의 길이를 구할 수 없어 나오지않음
				for(int i = 0; i<two_ar.length;i++) {//3
					two_ar[i] = new int[i+2]; // 2,3,4 길이 생성
					for(int j=0; j <two_ar[i].length; j++){//4
						two_ar[i][j] = (i+1)*(j+1);
						System.out.print(two_ar[i][j]+"\t");
					} System.out.println();
				}
	}

}
