package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardInsertView {
	BoardDTO input(){
		// 번호 제목 내용 작성자 작성시간 글암호 조회수
		// 번호 - 시퀀스 값 자동 1증가(입력X)
		// 제목 내용 작성자(member id만 가능) 입력
		// 작성시간 - 기본 sysdate
		// 글암호 입력
		// 조회수
		Scanner sc = new Scanner(System.in);
		System.out.println("제목 입력 : ");
		String title = sc.nextLine();

		System.out.println("내용 입력 : ");
		String contents = sc.nextLine();

		System.out.println("작성자 입력 : ");
		String writer = sc.nextLine();

		System.out.println("글 암호 입력 : ");
		int password = sc.nextInt();
		
		BoardDTO dto = new BoardDTO();

		dto.setTitle(title);
		dto.setContents(contents);
		dto.setWriter(writer);
		dto.setPassword(password);
		
		return dto;
	}
}
