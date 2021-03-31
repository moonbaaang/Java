package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MemberClient {

	public static void main(String[] args) {
		try {
		Socket s = new Socket("192.168.0.113", 9996);	//("domain 또는 ip")
		System.out.println("=====서버와의 연결중=====");
		
		InputStream i = s.getInputStream();
		DataInputStream ds2 = new DataInputStream(i);
		String input_b = ds2.readUTF();
		System.out.println(" 아이디 암호 입력");
		
		Scanner key = new Scanner(System.in);
		System.out.println("아이디 입력 : ");
		String id = key.next();
		System.out.println("암호 입력 : ");
		String pw = key.next();
		
		// 클라이언트가 서버로 hello server 문자열을 전송 = 클라이언트 출력
		
		OutputStream o = s.getOutputStream();
		DataOutputStream ds = new DataOutputStream(o);
		//ds.writeInt(100); // 데이터를 직접 전달할 수있음
		// o.write(byte 1개 / byte[]) 
		
		String data = "hello server";
		ds.writeUTF(data); //string 을 전송하는 메서드

		System.out.println("회원가입 결과" + input_b);
		s.close();
		System.out.println("=====서버와의 연결 종료=====");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
