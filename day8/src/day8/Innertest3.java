package day8;

public class Innertest3 {

	public static void main(String[] args) {
		int out = 10;
		class Inner{
			public int count() {
				int cnt = 0;
				for(int i = 0; i < out; i++) {
					cnt += i;
				} // for end
				return cnt; //0-9 총합
			} // count end
			
		} //class Inner end

		System.out.println(new Inner().count());

		
		// 지역 내부 클래스
		//interface Runnable { public void run();}
/*		class RunnableSub implements Runnable{
			public void run() {
				System.out.println("실행중");
			}
		}
		// 지역 내부 객체 생성
		RunnableSub sub = new RunnableSub(); // 좌항 Runnable 가능
		//메소드 호출
		Thread t1 = new Thread(sub);
		t1.start();
*/
		new Thread(new Runnable() {
			public void run() {
				System.out.println("실행중");
			}
		}).start();
		
		new Thread(()->{System.out.println("실행중222");}).start();
		
		myInter i = new myInter() {
			public void mi1() {
				System.out.println("mi1");
			}
			public void mi2() {
				System.out.println("mi2");
			}
			String name = "100";
			public void mi3() {
				System.out.println("하위 추가 메소드 m3");
			}
		};
		
		i.mi1();
		i.mi2();
	//	i.mi3(); 하위 클래스 객체를 받아 myInter 클래스로 자동 형변환하고있다. 따라서 myInter에 포함되지 않은
	//	mi3는 호출이 불가능하다. (String name도 동일)
		
/*		new myInter() {
			public void mi1() {
				System.out.println("mi1");
			}
			public void mi2() {
				System.out.println("mi2");
			}
		}.mi2();
		
		// 두번 해야하는데?
		 */
		
		
	}//main end
}

interface myInter {
	/*public abstract*/ void mi1();
	void mi2();
}


abstract class A{
	abstract void ma();
	public void mb() {System.out.println("mb 호출");}
}




