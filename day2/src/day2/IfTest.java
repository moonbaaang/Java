package day2;

public class IfTest {

	public static void main(String[] args) {
		// 국영수 100 88 77
		// 총점/ 정수평균 / 실수평균
		// 정수평균이 70점 이상 , 합격/불합격
		String name = "이자바";
		//1-100 사이 난수를 발생
		int kor = (int)(Math.random() * 100)+1; //자동수정 - 실행?
		int eng = (int)(Math.random() * 100)+1;
		int mat = (int)(Math.random() * 100)+1;
		int sum = kor+eng+mat;
		int avgInt = sum/3;
		double avgDouble = (double)sum/3;
		System.out.println("학생 이름 ="+name);
		System.out.println("국어 = "+kor);
		System.out.println("영어 = "+eng);
		System.out.println("수학 = "+mat);
		System.out.println("총점 = "+sum);
		System.out.println("정수평균 = "+avgInt);
		System.out.println("실수평균 = "+avgDouble);
		
/*		if (avgInt>=70) {
			System.out.println("Pass");
			System.out.println("공부 열심히 하셨네요!");
		} else {
			System.out.println("Fail");
			System.out.println("공부 더 열심히 하셔야겠네요!");
		}
		
		System.out.println(avgInt>=70?"Pass":"Fail");
	}
	
*/
	// 80이상 A등급
	// 60이상 80미만 B등급
	// 40이상 60미만 C등급
	// 나머지 낙제
		
/*		if (avgInt >= 80) {
			System.out.println("A등급입니다.");
		}
		else if (avgInt >= 60 && avgInt < 80) {
			System.out.println("B등급입니다.");
		}
		else if (avgInt >= 40 && avgInt < 60) {
			System.out.println("C등급입니다.");
		} else {
			System.out.println("낙제입니다!");
		}
*/
		int newavgInt = avgInt / 10;
		switch (newavgInt) {
		case 10:
		case 9:
		case 8:
			System.out.println("A등급입니다.");
			break;
		case 7:
		case 6:
			System.out.println("B등급입니다.");
			break;
		case 5:
		case 4:
			System.out.println("C등급입니다.");
			break;
		default:
			System.out.println("낙제 입니다.");
		}
	}
}