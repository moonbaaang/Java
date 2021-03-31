import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
/* 			명령행 매개변수 입력
	a.txt b.txt -> a.txt가 존재하지 않으면? -> fi를 생성 불가능하다.
	src/FileCopyTest.java b.txt -> b.txt 출력파일이 존재하지 않으면? -> 출력이 없음. -> b.txt 생성해서 출력하면 된다. (생성은 되어있음)
	src/FileClassTest.java b.txt -> b.txt 출력파일 존재하면 -> 기존의 파일 내용은? >> 삭제, 이후 출력 /// FileOutputStream 두번째 매개변수에 둘 시 기존내용 유지, 추가 출력
*/
		try {
		FileInputStream fi = new FileInputStream(args[0]); //입력파일은 반드시 존재해야한다.
/*		File f = new File(args[0]);
		if(f.exists()) {
			FileInputStream fi = new FileInputStream(f);
		}
*/
//		FileOutputStream fo = new FileOutputStream(args[1]);
		FileOutputStream fo = new FileOutputStream(args[1], true);
		while(true) {
			int result = fi.read(); //result = 97 > a
			fo.write(result); //int 데이터에서 1바이트만 출력 > a
			if(result == -1) {break;}
		}
		fi.close();
		fo.close();		
		
		} catch(IOException e) {
			e.printStackTrace(); // 오류정보 추적 후 메시지 전달
		}
	}

}
