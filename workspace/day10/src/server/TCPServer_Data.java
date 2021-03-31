package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer_Data {
	public static void main(String[] args) {
		//ServerSocket port번호 = 서버프로그램 식별번호 - 2^16 = 0~65535
		// 0-1024 이내 window ftp telnet http 프로토콜 포트 예약
		// 1025 - 5000 이내 권고사항 os사용 소지
		try {
			ServerSocket ss = new ServerSocket(9996); // 서버 시작 연결 대기중
			System.out.println("=====서버시작 대기중=====");
			while(true) {
				Socket s = ss.accept(); // 연결 승인 Socket 생성(-연결점);
				System.out.println("=====클라이언트와 연결중=====");
				InputStream i = s.getInputStream();
				DataInputStream ds = new DataInputStream(i);
				String input_b = ds.readUTF();
				//o.write(byte[])를 받았음 > read 할 때 바이트 배열로 읽음
			
				System.out.println("=====클라이언트가 서버로 전송한 데이터= "+input_b);
				
				//클라이언트로 hello client 문자열 전송 = 서버가 출력
				OutputStream o = s.getOutputStream(); //getWriter는 없다.
				DataOutputStream ds2 = new DataOutputStream(o);
				String data = "hello client";
				ds2.writeUTF(data);
				
				
				s.close();
				System.out.println("=====클라이언트와 연결종료====="); //다음 클라이언트 대기
			}
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
