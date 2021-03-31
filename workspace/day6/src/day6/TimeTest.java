package day6;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		// jdk  초기날짜
		Date now = new Date();
		System.out.println(now);
		// Date 기능을 Calendar로 이동함
		Calendar cal = Calendar.getInstance(); // new 키워드 사용하지않음
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		
		//날짜 시간 형식을 정해서 출력
		SimpleDateFormat sdf = new SimpleDateFormat
				("yyyy -MM -dd E HH:mm:ss");
		System.out.println(sdf);
		String date1 = sdf.format(now);
		String date2 = sdf.format(cal.getTime());
		System.out.println(date1);
		System.out.println(date2);
		
		//숫자 포맷 3.333333
		//java.text 에 있음
		DecimalFormat df = new DecimalFormat(" ###.###");
		System.out.println(df.format((double)10/3));
		//문자 포맷
		System.out.println(String.format("%10s", "java")+ "|");
		System.out.println(String.format("%-10s", "java")+ "|");
	}

}
