package day6;

import java.util.regex.Pattern;

public class PatternTest {

	public static void main(String[] args) {
		// 정규표현식 전용 문자열 (regex : regular expression)
		// 010- 시작  / 국번 3-4자리 번호 / 전화번호 4자리 숫자
		System.out.println(Pattern.matches
				("010-[0-9]{3,4}-[0-9]{4}", "010-1234-5678"));
		System.out.println(Pattern.matches
				("010-[0-9]{3,4}-[0-9]{4}", "012-1234-5678"));
		System.out.println(Pattern.matches
				("010-[0-9]{3,4}-[0-9]{4}", "010-123-5678"));
		System.out.println(Pattern.matches
				("010-[0-9]{3,4}-[0-9]{4}", "010-123a-5678"));
		
		// 1> id-알파벳,숫자,!#$%_ 구성.8-10자리 가능[a-zA-Z-0-9!#$%_]{8,10}
		// 2> @
		// 3> 이메일 서버 - 알파벳, 숫자구성, 3-10자리 가능 [a-zA-z0-9]{3,10}
		// 4> .  ----> 정규표현식에서 아무문자 개수 무관하다는 의미를 갖고있음 그러나 우리는 .이라는 기호를 사용
		//   하고 싶음  >> \\.
		// 5> com or co.kr or go.kr(com|co.kr|go.kr|) > grouping
		
		String myemail = "javadosa1!@campus.com";
		boolean result = Pattern.matches
				("[a-zA-z0-9!#$%_]{8,10}@[a-zA-z0-9]{3,10}\\.(com|co.kr|go.kr)",
						myemail);
		if(result==true) {
			System.out.println(myemail+"은 이메일로 적합합니다.");
		}
		
		String test = "anyword";
		boolean result2 = Pattern.matches
				("\\w{1,}", test);
		if(result2 ==true) {
			System.out.println("맞냐고");
		}
		//[표현형태(0-9..)]{최소횟수, 최대횟수(최대횟수는 생략가능)} (문자그루핑) 
		// * + ? \\w \\d
	}

}
