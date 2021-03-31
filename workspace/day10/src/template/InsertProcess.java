package template;

import java.io.FileWriter;
import java.util.Scanner;

public class InsertProcess {
	void process() {
		Scanner key = new Scanner(System.in);
		//사원등록 추가 입력
		System.out.println("  사번 입력  : ");
		int id = key.nextInt();
		System.out.println("  이름 입력  : ");
		String name = key.next();
		System.out.println("  급여 입력  : ");
		double salary = key.nextDouble();
		
		Controller c = Controller.getInstance();
		c.insert(id, name, salary);
	}
}
