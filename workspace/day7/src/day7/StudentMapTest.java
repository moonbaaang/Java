package day7;


class Student<T>{
	T id;
	String name;
	int kor, eng, mat;

	public Student(T id, String name, int kor, int eng, int mat) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public boolean equals(Object o) {
		int total = kor+eng+mat;
		int othertotal = ((Student)o).kor+((Student)o).eng+((Student)o).mat;
		if(total == othertotal) { 
			return true;
		} else { return false; }
	}
	public String toString() {
		int total = kor+eng+mat;
		return id+"-"+name+"-"+total;
	}
	
}


public class StudentMapTest {
	public static void main(String args[]) {
		Student<Integer> s1 = new Student<Integer>(100, "김자바", 100, 90, 80); //우항의 <>은 작성하지 않아도 된다.
		Student<String> s2 = new Student("200", "박지원", 50, 100, 70); //id를 String으로도 만들고싶다?
		System.out.println(s1);
		System.out.println(s2);
		
		if(s1.equals(s2)) {
			System.out.println("두 학생의 총점이 같다.");
		}

		
	}
}
