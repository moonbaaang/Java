package EmploySalary;

class Employee{
 	int id;
 	String name;
 	int baseSalary;
 	int generalFee;
 	int totalSalary;
 	
// 	Employee(){} 를 해두면 상속할 때 오류 X
 	Employee(int id, String name, int baseSalary, int generalFee){
 		//super() 생성자의 첫문장은 항상 super() 
 		this.id = id;
 		this.name = name;
 		this.baseSalary = baseSalary;
 		this.generalFee = generalFee;
 	}
 	
 	public void calcTotalSalary() {
 		totalSalary = baseSalary + generalFee;
 	}

}

class Manager extends Employee{
	int manFee;
	Manager(int id, String name, int baseSalary, //생성자
			int generalFee, int manFee){
		super(id, name, baseSalary, generalFee);
		//자바의 모든 생성자 = super(); 자동 정의. Employee() 생성자를 호출
		//super(1,"aa",2,3) 을 사용 시 Employee(int St int int)생성자 호출
/*		this.id = id; //super.id 가 정확하지만 매니저 내부에 id가 없기때문에 this를 붙여도 됨
		this.name = name;
		this.baseSalary = baseSalary;
		this.generalFee = generalFee; // 이미 위에 정의되어있어 이 문장은 필요없음.
*/
		this.manFee = manFee; // super를 붙이면 안된다. (상속받은것이 아니기 때문)
	}
	@Override
	public void calcTotalSalary() {
		super.calcTotalSalary(); // 위 Employee의 계산대로 됨
		totalSalary += manFee;
	}
}

class Engineer extends Employee{
	int certiFee;
	int techFee;
	Engineer(int id, String name, int baseSalary, int generalFee, 
					int certiFee, int techFee){
		super(id, name, baseSalary, generalFee);
		this.certiFee = certiFee;
		this.techFee = techFee;
	}
	@Override
	public void calcTotalSalary() {
		super.calcTotalSalary();
		totalSalary = baseSalary + generalFee + certiFee + techFee;
	}
	
}

class Secretary extends Employee{
	int secFee;
	public Secretary(int id, String name, int baseSalary, int generalFee,
			int secFee) {
		super(id, name, baseSalary, generalFee);
		this.secFee = secFee;
	}
	@Override
	public void calcTotalSalary() {
		super.calcTotalSalary();
		//totalSalary += secFee;
		totalSalary = baseSalary + generalFee + secFee;
	}
	
}

public class SalaryTest {

	public static void main(String[] args) {
		Employee e [] = new Employee[4];
		// 1.상속 2.생성자(타입 순서 갯수....)
		e[0] = new Employee(1000,"이사원",10000,5000);
		e[1] = new Manager(2000,"김간부",20000,10000,10000);
		e[2] = new Engineer(3000,"박기술",15000,7500,5000,5000);
		e[3] = new Secretary(4000,"최비서",15000,7000,10000);
		
		System.out.println("사번  :  이름  :  본봉  :  총급여 ");
		for(int i = 0;i<e.length;i++) {
			e[i].calcTotalSalary();
			// e[i]자동형변환 이후에 e[i].overriding메소드() = 객체마다 포함
			// e[i] 자동형변환 이후에 e[i].멤버변수 - Employee 클래스 선언
			System.out.println(e[i].id+":"+e[i].name+":"+
						e[i].baseSalary+":"+e[i].totalSalary);
			if(e[i] instanceof Engineer) {
//				Engineer en = (Engineer)e[i];
				System.out.println(((Engineer)e[i]).certiFee+":"+
				((Engineer)e[i]).techFee);
				}
			//Engineer 객체인 경우에는 certiFee, techFee 같이 출력하라
			}
		}
	}


