class A {
	int add(int ... numbers){
		System.out.println("전달 매개변수 갯수 = "+numbers.length); // length는 배열에서만 사용 가능한데 내부적으로 배열로 받아준다.
		int sum = 0;
		for(int one : numbers) {
			sum += one;
		}
		return sum;
	}
}
public class VariableArgumentTest {

	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		A a1 = new A();
		int result = a1.add(1,2);
		System.out.println("총합 = "+result);
		result = a1.add(1,2,4,5,6,7,8,2,3,1,5,15);
		System.out.println("총합 = "+result);
		result = a1.add(1,2,3462,3);
		System.out.println("총합 = "+result);
	}

}
