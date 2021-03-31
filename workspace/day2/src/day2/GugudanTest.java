package day2;

public class GugudanTest {

	public static void main(String[] args) {
		// 2단?
		for (int i = 1; i<=9;i++) {
			for (int j = 2; j<=9;j++) {
				if (j==5) continue;
				System.out.print(j +"*"+i+"="+j*i+"\t");	
			}//inner for end
			System.out.println();//줄바꿈
		}// outer for end

	}//main end

}
