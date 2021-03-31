package day6;


// 동시실행 내용 생기면 멀티스레드 코드 작성
// 동시 실행중에 특정 객체 접근 시 Synchronized 블록 순서 지키고 1번에 1개 스레드 접근
//>>> singleton 패턴 자주 등장
// 스레드를 직접 만들 일은 거의 없을 것이나 이해는 필요 (내부에 이미 구현 완성 API) - 웹서버 , 스프링 등


class MyStack{
	char[] ch = new char[10];
	int idx = 0;
	void push(char c) { //lock
		synchronized(ch) { // 남발 시 수행속도는 느려질 수 있음
		ch[idx] = c;
		System.out.println(Thread.currentThread().getName()+", "	
				+ "idx = "+idx + " , ch[idx] = "+ch[idx]);
		idx ++;
		}
	}
}

class MyStackThread extends Thread{
	MyStack st;
	char c;
	MyStackThread(MyStack st, char c){
		this.st = st;
		this.c = c;
	}
	public void run() {
		for(int i = 1; i<=5; i++) {
			st.push(c);
		}
	}
	
}
public class SynchronizedTest {

	public static void main(String[] args) {
		MyStack st = new MyStack();
		MyStackThread t1 = new MyStackThread(st,'a');
		MyStackThread t2 = new MyStackThread(st,'b');
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

}
