package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class MemberServer {
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
				String inform = ds.readUTF();
				System.out.println("====아이디 암호===="+inform);
				
				//o.write(byte[])를 받았음 > read 할 때 바이트 배열로 읽음
				String ids[] = {"java", "jsp", "spring"};
				String[] informARR = inform.split(" ");
				String id = informARR[0];
				String pw = informARR[1];
				
				boolean duplicate = false;
				for (String one : ids) { //최대 3번
					if(id.equals(one)) {
						duplicate = true;
						break;
					}
				}
				
				OutputStream o = s.getOutputStream(); //getWriter는 없다.
				DataOutputStream ds2 = new DataOutputStream(o);
				if(duplicate == true) {
					ds2.writeUTF("다른 아이디를 사용하세요");
				} else {
					ds2.writeUTF(id+" 는 사용가능합니다.");
				}

				
				s.close();
				System.out.println("=====클라이언트와 연결종료====="); //다음 클라이언트 대기
			}
		}	
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
