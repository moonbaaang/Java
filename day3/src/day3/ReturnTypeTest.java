package day3;

class Test {
	int ma(){ //메서드 정의
		int i = 10;
		return i*i; //ma() 메서드를 호출 후 실행 시 결과
	}
	String mb(){
		String s = "java";
		return s.toUpperCase();
	}
	int[] mc(){
		int [] i = new int [3];
		i[0] = 100;
		i[1] = 200;
		i[2] = 300;
		return i;
	}
	void md(){
		int i =10;
		System.out.println(i*i); // return으로 끝나지 않았음 결과를 돌려주진 않고 출력만 해줌
	}
	void me() {
		int i = 0;
		System.out.println("me메소드 시작");
		if (i==0) {
			return; // 메소드를 중단
		}
		System.out.println("me메소드 종료");
	}
}

public class ReturnTypeTest {

	public static void main(String[] args) {
		Test t = new Test();
		int r1 = t.ma(); // 메소드 호출 실행
		System.out.println(r1);
		String r2 = t.mb();
		System.out.println(r2);
		int[] r3 = t.mc();
		for (int one:r3) {
			System.out.println(one);
		}
		t.md();
		t.me();
		System.out.println("main 종료");
	}

}
