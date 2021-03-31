import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest3 {

	public static void main(String[] args) {
		FileReader fi = null;
		FileWriter fo = null;
		try {
			// 라인번호 정수 : 왼쪽 라인 추가
		fi = new FileReader("src/FileCopyTest3.java");
		Scanner sc = new Scanner(fi); //한 줄씩 읽어올 수 있도록 변경함
		int linenum = 1;
		fo = new FileWriter("linecopy.txt");
		while(sc.hasNextLine()) {
			String line = sc.nextLine(); // 한 라인을 읽어올 수 있다. \n를 만나면 라인 끝, \n은 사라짐
			//System.out.print(linenum++ +":" + line+"\n");
			fo.write(linenum++ +":" + line+"\n");
		}		
		} catch(IOException e) {
			e.printStackTrace(); // 오류정보 추적 후 메시지 전달
		} finally { //close()는 반드시 진행되어야 하고 예외처리를 반드시 해준다.
			try {
			fi.close();
			fo.close();
			} catch(IOException e) {}
		}
	}
}
