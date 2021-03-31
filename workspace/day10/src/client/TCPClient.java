package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
		Socket s = new Socket("192.168.0.113", 9997);	//("domain 또는 ip")
		System.out.println("=====서버와의 연결중=====");
		// 클라이언트가 서버로 hello server 문자열을 전송 = 클라이언트 출력
		
		OutputStream o = s.getOutputStream(); //getWriter는 없다.
		String data = "hello server";
		// String -> byte[] 변경? getBytes
		// byte[] -> String 변경방법? byte[] b = new byte[100]; , String sb = new String(b);
		byte[] data_byte = data.getBytes(data);
		System.out.println(data_byte.length);
		o.write(data_byte); //int a > a한글자 / byte[]
		
		// 클라이언트가 서버로부터 입력받는 방법1
		InputStream i = s.getInputStream();
		//o.write(byte[])를 받았음 > read 할 때 바이트 배열로 읽음
/*		byte b[] = new byte[100];
		i.read(b);
		//byte[] -> String 으로 바꾸어야함.
		String input_b = new String(b); 
		System.out.println("=====서버가 클라이언트로 전송한 데이터= "+input_b); */
		
		
		// 방법2
/*		Scanner sc = new Scanner(i);
		String input_b = sc.nextLine();
		System.out.println("=====서버가 클라이언트로 전송한 데이터= "+input_b); */
		
		s.close();
		System.out.println("=====서버와의 연결 종료=====");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
