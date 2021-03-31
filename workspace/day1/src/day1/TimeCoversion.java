package day1;

public class TimeCoversion {

	public static void main(String[] args) {
		int time = 10000;
		int time2 = time;
			
		// 1시간 44분 (초 단위시간) > 시 , 분 , 초 단위로 변경하여 출력
		// 10000초는 xx시간 xx분 xx초 입니다.
		int hour = time/3600;
		time2 = time2 % 3600;
		int minute = time2 / 60;
		int second = time2 % 60;
		System.out.println(time+"초는 "+hour+"시간 "+minute+"분 "+second+"초 입니다.");
		// hour 변수가 24시간 초과되면 "만 1일 경과했습니다." 또는 "1일 이내입니다."
		String judge = hour >= 24 ? "만 1일 경과했습니다." : "1일 이내입니다.";
		System.out.println(judge);
	}

}
