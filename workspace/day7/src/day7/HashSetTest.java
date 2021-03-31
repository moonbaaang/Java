package day7;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public static void main(String[] args) {
//		HashSet set = new HashSet();
		HashSet<Employee> set = new HashSet<Employee>();

/*		set.add(100);
		set.add(3.14);
		set.add("java");
*/
		Employee e1 = new Employee(400, "박부장", 88000.99); //e1 : Employee 객체 주소
		set.add(e1);
		set.add(e1); // 중복저장이므로 무시됨
//		set.add(new Employee(400, "박부장", 88000.99)); //새로운 객체를 생성, e1과 중복된 객체가 아님 
		System.out.println(set.size());
		
		//for (int i = 0; i < set.size(); i++) {
			// set.get(i); >>> 인덱스로 관리되지 않고, get메서드를 포함하지도 않는다.
			Iterator<Employee> it = set.iterator(); //반복자(set 저장 데이터들을 순서없이 모은 객체)
			while(it.hasNext()) { //hasNext() 다음데이터 존재 여부
				//Object o = it.next(); //다음 데이터를 조회
				Employee o = it.next(); 
				//System.out.println(o);
				System.out.println(o.name);
			}
			
			HashSet<Integer> lotto = new HashSet<Integer>();
			//1-45 사이의 난수를 6개 생성하여 lotto라는 set에 저장한다.
			//lotto 출력하면 6개 정수가 출력되도록 처리(저장 - 조회 출력순서는 일치하지 않아도됨)
			while(true) {
				int number = (int)(Math.random()*45)+1;
				lotto.add(number);
				if(lotto.size() ==6 ) {break;}
			}
			Iterator<Integer> it2 = lotto.iterator();
			while(it2.hasNext()) {
				System.out.println(it2.next());	
			}

			for(Integer one : lotto) {// >> lotto.size()만큼 자동 반복된다.
				System.out.println(one);	
			}
/*			int ar [] = new int [5];
			for(int one: ar) {
				System.out.println(one);
				// ar 배열에 들어가있는 데이터 하나
			// for(: 배열 list set)
			}
			
			ArrayList<Employee> list1 = new ArrayList<Employee>();
			for (Object one : list1) {
				System.out.println(one);
*/
			}

}

