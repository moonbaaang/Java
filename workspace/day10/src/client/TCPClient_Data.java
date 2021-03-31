package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient_Data {

	public static void main(String[] args) {
		try {
		Socket s = new Socket("192.168.0.113", 9996);	//("domain 또는 ip")
		System.out.println("=====서버와의 연결중=====");
		
		// 클라이언트가 서버로 hello server 문자열을 전송 = 클라이언트 출력
		
		OutputStream o = s.getOutputStream();
		DataOutputStream ds = new DataOutputStream(o);
		//ds.writeInt(100); // 데이터를 직접 전달할 수있음
		// o.write(byte 1개 / byte[]) 
		
		String data = "hello server";
		ds.writeUTF(data); //string 을 전송하는 메서드
		
		
		// 클라이언트가 서버로부터 입력받는 방법1
		InputStream i = s.getInputStream();
		DataInputStream ds2 = new DataInputStream(i);
		String input_b = ds2.readUTF();
		
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
