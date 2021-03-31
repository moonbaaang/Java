package day2;
import java.text.DecimalFormat;

public class ArrayTest {

	public static void main(String[] args) {
		//5명 학생 시험점수
		String names [] = new String [5];
		int [] scores [] = new int [names.length][3];
		double avg [] = new double[names.length];
/*		저장되는 데이터
 * 		국어 영어 수학 점수가 scores 1차 배열에 해당
 * 		점수는 1부터 100까지 난수
 * 		각 학생별 3과목(총점) 실수평균 avg 배열 저장하고 출력
 */
		names[0] = "문병전";
		names[1] = "문지영";
		names[2] = "문승현";
		names[3] = "문상원";
		names[4] = "정차미";
		
		
		// 시험점수 저장
		
		for(int i=0;i<names.length;i++) {
			int sum =0;
			System.out.print(names[i]+"의 점수 : ");
			for(int j = 0 ; j<scores[i].length; j++) {
				scores[i][j] = (int)(Math.random()*100+1);
		    	System.out.print(scores[i][j]+" ");
				sum += scores[i][j]; //3번
			}
			avg[i] = (double)sum/scores[i].length;
			java.text.DecimalFormat dec = new DecimalFormat("##.00");
			System.out.println(dec.format(avg[i]));
//			System.out.print(avg[i]);
			System.out.println();
		}
//		System.out.println("학생수=점수갯수 : "+scores.length);
//		System.out.println("학생수=점수갯수 : "+names.length);
		for(int i=0;i<names.length;i++) {
			
		    for(int j =0; j<scores[0].length;j++) {
/*			names = new String[10]; >>> 기존 names 배열이 사라지고 새로운 배열을 만들어냄 (기존 내용 사라짐)
// 			복사를 위해서는
//		    String [] names2 = new String [10];
//			for(int i = 0; i < names.length, i++){
//		    	names[i] = names[i]
//		    }
 * 			for (int i = 0; i< names2.length, i++){
 * 				System.out.println(names2[i]);
 * 			}
	
			또다른 방법의 for문
			for (데이터 타입 변수명 : 반복 배열 변수명 )
		    for (String n : names2){
		    	System.out.println(n); 
		    } >>>> names2 의 인덱스 만큼 n을 반복한다. 위의 for문과 일치한다.
		    	
		    	*/
		    } 
		}
	}
}
