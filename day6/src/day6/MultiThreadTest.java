package day6;

class Multi1 extends Thread {
	public void run() { // run 메소드를 오버라이딩 함
	for(int i = 1;i<=50;i++) {
		System.out.println(getName()+" - 메인 작업 수행");
		}
	}
}

public class MultiThreadTest {

	public static void main(String[] args) {
		Multi1 m1 = new Multi1();
		m1.setName("m1"); // 스레드 이름 설정
		m1.start(); //run() 동시실행
		
		Multi1 m2 = new Multi1();
		m2.setName("m2");
		m2.start();
		
		for(int i = 1;i<=50;i++) {
			System.out.println("다른 작업 수행");
		}
	}
}
