package day7;

import java.util.HashMap;
import java.util.Set;

public class PhoneMapTest {

	public static void main(String[] args) {
		String [] s1 = new String[3];
		s1[0] = "010-1234-5678";
		s1[1] = "02-3432-1293";
		s1[2] = "ss@multi.com";
		
		s1 = new String[30];
		
		//json 형태
		String [] s2 = {"010-1234-5678","02-3432-1293","ss@multi.com"};
		// s1과 s2의 결과는 같다.
		s2 = new String[30];
		HashMap<String, String[]> phone = 
				new HashMap<String, String[]>();
		
		phone.put("초등친구", new String [] {"010-3123-1323", "02-3432-0412", 
			"031-3231-5213",  "fri1@multi.com"});
		// new String [] 을 설정해야 배열로 인식
		phone.put("고등친구", new String [] {"010-1111-2222", "02-3432-0862", 
				"031-3231-5098",  "fri2@multi.com"});
		phone.put("회사동기", new String [] {"010-1991-2341", "02-3431-1365", "fri3@multi.com"});
		phone.put("회사상사", new String [] {"010-9988-8888", "fri4@multi.com"});
		System.out.println("총연락처 갯수 = " + phone.size());
		
		if(phone.containsKey("회사동기")) { // 회사동기라는 키를 포함하고 있는지?
		String[] phonelist1 = phone.get("회사동기");
		for(String one : phonelist1) {
			System.out.println(one);
			}
		}
		//회사동기의 연락처 정보 조회
		if(phone.containsKey("사장님")) { 
		String[] phonelist2 = phone.get("사장님");
		for(String one : phonelist2) {
			System.out.println(one);
			} 
		} else {
				System.out.println("사장님 연락처는 없습니다.");
		}
		
		// 내 연락처 모든 정보 조회
		// 초등친구 : xxx | xxxxxx | xxxxxx
		
		//key표현은 어떻게?
		//모든 key 조회 - 4번 반복될 것
		//for(int i = 1; i<=4,:i++)  ???
		Set<String> keys = phone.keySet(); //key는 중복을 허용하지 않는다.
		for(String k : keys) {
			String [] phonelist = phone.get(k);
			for(String one: phonelist) {
				System.out.print(one + " | ");
			}
			System.out.println();
		}
	}
}

