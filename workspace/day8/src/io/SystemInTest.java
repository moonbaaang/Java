package io;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {

	public static void main(String[] args) {
		System.out.println("키보드 입력을 시작하세요");
		//0이 입력될때 까지 입력, 1바이트
/*		try {
		while (true) {
			int result = System.in.read();
			System.out.print((char)result);
			if(result == -1) { // 0입력시 종료하고싶다면 48 또는 '0'/ 엔터키일때 \n 또는 13 /-1 (ctrl+z)
				break;
				}
			}
		} catch(IOException e) {
				e.printStackTrace();
		}
*/		

//한글 입력
		try {
				InputStream is= System.in; // System.in (키보드)
				byte b[] = new byte[100];
				
				int cnt = is.read(b); // 키보드 1바이트 입력, b배열 저장, cnt입력 개수
				String inputString = new String(b, 0, cnt); // 한 문자를 2바이트씩
				
				System.out.print(inputString);
			} catch(IOException e) {
				e.printStackTrace();
		}
	}
}// 한글을 입력하려면 2바이트를 읽어올 수 있어야 한다.
