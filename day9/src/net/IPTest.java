package net;

import java.net.InetAddress;

public class IPTest {

	public static void main(String[] args) {
		try {
			// 3자리.3자리.3자리.3자리 > IPv4
			// 0-255.0-255.. > 자리가 모자람, IPv6로 넘어가고있음
		InetAddress myIP = InetAddress.getLocalHost();
		System.out.println(myIP.getHostAddress());
		
		InetAddress [] ips = InetAddress.getAllByName("www.multicampus.co.kr");
		for(InetAddress one : ips) {
			System.out.println(one.getHostAddress());
		}
		} catch (Exception e) { e.printStackTrace(); }
		// www.google.com 접속 > 내 컴퓨터가 클라이언트가 된다. > ip:port를 알아야하는데 접속이 된다?
		// 인터넷 메이저 사이트들 - 서버의 이름을 지음 = domain
		// 인터넷 관리 기구에 이름 제시, 등록

	
	}
}
