package day7;


import java.util.ArrayList;

class Employee{
	int id;
	String name;
	double salary;
	
	//Source - Generate Constructor
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return id+"-"+name+"-"+salary;
	}
	
}

public class ArrayListTest {
	public static void main(String[] args) {
			
		//ArrayList list = new ArrayList(5);
		/*여러 타입 데이터를 저장 가능하다. 
		 단, 동일타입 데이터만 저장하되 갯수 변경을 의도
		 1> 컴파일러 컴파일 시점에 타입을 체크
		 2> 형변환이 필요없음 = 단순, 간결 , 실행 시 오류가 줄어듦
		 3> 타입이 정적으로 유지된다.
		 4> 타입 지정 X >> add(Object o) / Object <----get(0)
		 5> 타입 지정 O >> add(지정한타입 o) / 지정한타입 <----get(0)
		 6> generic 타입을 지정한 ArrayList (한가지 타입만 지정했다는 뜻)
		*/
		
		//ArrayList<String> list = new ArrayList<String>(5);
		
		// <Employee>로 설정도 가능 > generic 타입을 지정함
		ArrayList<Employee> list = new ArrayList<Employee>(5);
		
		//System.out.println(list.size());
		//저장된 데이터의 개수를 나타낸다.
		
/*		list.add(100); //int 타입 데이터 (Integer 타입으로 자동 변경 가능)
		list.add(new Integer(200)); // Integer타입의 객체
		list.add(2.55); // double 타입 데이터 (기본형변수)
		list.add(new Double(32.14)); // Double타입의 객체
		list.add(300);
		list.add(9.99);
		list.add("java program");
		list.add(0, "변경"); // 0번 인덱스에 "변경"이라고 끼워넣어 저장
		list.set(0, "변경 확인"); //0번 인덱스의 내용을 "변경 확인"으로 수정
		list.remove(0);
*/		
		Employee e1 = new Employee(100, "이사원", 56000.55);
		Employee e2 = new Employee(200, "최대리", 66000.55);
		Employee e3 = new Employee(300, "박과장", 76000.55);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		System.out.println(list.size());
		
		// list 내에 멀티캠퍼스 문자열이 있다면 삭제
		if(list.contains("멀티캠퍼스")) {
			System.out.println(list.indexOf("멀티캠퍼스"));
			list.remove("멀티캠퍼스");			
		}

		for (int i = 0; i<list.size(); i++) {
			Object o = list.get(i);
			System.out.println(i+" 번 인덱스 = "+o/*+list.get(i)*/);
			//만약 조회 데이터가 Employee 객체였다면 객체의 name이라는 변수만 출력해보기
			// sysout(((Employee)o).name); 를 진행한다.(형변환)
			// 또는 Employee로 형변환이 가능한지 확인해보고
			if (o instanceof Employee) {
				System.out.println(((Employee)o).name);
			}
			//System.out.println(o.name);
			// Employee만 저장했을 때 
		}
		//autoboxing, unboxing
		int i = new Integer(500);
		Integer in = 300; // Integer 타입의 객체에 int 값을 대입 
	}

}
