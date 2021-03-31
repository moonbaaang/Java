import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class EmployeeTest{
	int id;
	String name;
	double salary;
	EmployeeTest(int id, String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String toString() {
		return id+"|"+name+"|"+salary;
	}
	
}

public class MenuTest {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		EmployeeTest e = null; 
		//파일이나 db에 데이터를 영구적으로 저장하여 보존(컴퓨터 전원이 꺼져도 O)
		
		while(true) {
			System.out.println("===다음과 같은 메뉴 이용 가능합니다===");
			System.out.println("1. 사원등록");
			System.out.println("2. 사원정보조회");
			System.out.println("3. 사원정보수정");
			System.out.println("4. 사원탈퇴");
			System.out.println("5. 프로그램 종료");
			System.out.println("번호입력 :");
			int menu = key.nextInt();
			
			if(menu == 1) {
				InsertProcess p = new InsertProcess();
				p.process();
			} else if(menu == 2) {
				System.out.println("사원정보조회를 선택하셨습니다.");
				try {
				FileReader fr = new FileReader("employee.txt");
				Scanner sc = new Scanner(fr);
				while(sc.hasNextLine()) {
					String line = sc.nextLine();

					String items[] = line.split("\\|");
					//Pattern ex) "010-[0-9]{3,4}-[0-9]{4}"
					//			  "(010|017|019)-[0-9]{3,4}-[0-9]{4}"
					String id = items[0];
					String name = items[1];
					
					double salary = Double.parseDouble(items[2]);
					System.out.println(id+"|"+name+"|"+salary*1.5);
				}
				sc.close();
				fr.close();
				
				} catch (IOException err) {
					err.printStackTrace();
				}

// 수정 사번 입력 : 100
// 수정항목 입력 : name 박수정 > 이름을 박수정으로 변경
// employee.txt 파일에서 한라인씩 읽어 "|" 분리 첫번째 요소(=사번) 이 100인 라인을 찾아 두번째요소인 이름 변경
// 모든 라인을 다시 employee.txt에 다시 저장
								
// FileWriter fw = new FileWriter("employee.txt") >다시 파일을 저장				
			} else if(menu == 3) {
				System.out.println("사원정보수정를 선택하셨습니다.");
				System.out.println("수정사번 입력 : ");
				String inputId = key.next(); //200 - int이나 nextInt로 읽지 않아도됨
				System.out.println("수정항목 입력 : "); // name 홍성진
				key.next();
				String inputName = key.next();
				
				ArrayList<String> list = new ArrayList<String>();
					try {
						FileReader fr = new FileReader("employee.txt");
						Scanner sc = new Scanner(fr);
					while(sc.hasNextLine()) {
						String line = sc.nextLine();

						String items[] = line.split("\\|");
						//Pattern ex) "010-[0-9]{3,4}-[0-9]{4}"
						//			  "(010|017|019)-[0-9]{3,4}-[0-9]{4}"
						String id = items[0];
						String name = items[1];
						String salary = items[2];
						if(id.equals(inputId)) {
							name = inputName;
							
						}
						
						System.out.println(id+"|"+name+"|"+salary);
					}
				///	sc.close();
				//	fr.close();
					
					FileWriter fw = new FileWriter("employee.txt");
					//fw.write(list.get(i)+"\n");
					
					for(String one : list) {
						fw.write(one+"\n");
					}
					fw.close();
					
					} catch (IOException err) {
						err.printStackTrace();
					}

				
			} else if(menu == 4) {
				System.out.println("사원탈퇴를 선택하셨습니다.");
				// 탈퇴 사번 입력 : 100
				// 100 사번을 찾아서 list에서 삭제함
			} else if(menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("해당 기능의 메뉴는 존재하지 않습니다.");
			}
		}
	}

}
