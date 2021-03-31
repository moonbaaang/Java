package runna;

class Multi1 implements Runnable{ // 다른 메소드를 extends 했을 시 Runnable implement
	public void run() { // run 메소드를 반드시 오버라이딩 함
	for(int i = 1;i<=50;i++) {
		System.out.println
		(Thread.currentThread().getName()+" - 메인 작업 수행"); 
		//getName()은 Thread를 상속받고 있지 않기에 사용 불가능
		}
	}
}

public class MultiThreadTest {

	public static void main(String[] args) {
		Multi1 m1 = new Multi1();
		Thread t1 = new Thread(m1); // implements Runnable 을 할 때 반드시 수행
		
		// 1.Priority + 2. 시간할당 + 3. 멀티코어 -10
		t1.setName("t1"); // 스레드 이름 설정
		t1.setPriority(Thread.MAX_PRIORITY);
	
		
		Multi1 m2 = new Multi1();
		Thread t2 = new Thread(m2);
		t2.setName("t2");
		t2.setPriority(Thread.MIN_PRIORITY);
		
		
		t1.start(); //run() 동시실행
		t2.start();
		
		for(int i = 1;i<=50;i++) {
			System.out.println("다른 작업 수행");
		}
	}
}
