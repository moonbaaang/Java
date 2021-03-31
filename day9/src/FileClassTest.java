import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileClassTest {

	public static void main(String[] args) {
		//File f = new File("src\\FileClassTest.java");
		//System.out.println("파일인지 여부 = "+f.isFile());
		//File f = new File("./src/FileClassTest.java");
		File f = new File(args[0]);

		if(f.exists()) {
			try {
				System.out.println("경로 = "+f.getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(f.isFile()) { // 파일인가?
				System.out.println("읽기여부 = "+f.canRead());
				System.out.println("쓰기여부 = "+f.canWrite());
				System.out.println(" 총길이(byte) = "+f.length());
				System.out.println("최종 수정시각 ="+f.lastModified());
				// 4자리 년도, 2자리 월, 2자리 일, 24시간형태 시간
				SimpleDateFormat sdf = new SimpleDateFormat
						("yyyy년도 MM월 dd일 HH:mm:ss");
				String dateString =
						sdf.format(new java.util.Date(f.lastModified()));
				System.out.println("최종수정시각 = "+dateString);
//				System.out.println(args[0]+": file");
			}
			else { //디렉토리인가?
				String[] details = f.list(); // 세부목록타입 String
				for(String one : details) {
					File ff = new File(args[0]+"/"+one);
					String result = "";
					if(ff.isFile()) {
						result = " : file";
					} else { // 디렉토리인 경우 또는 존재하지 않은 경우
						result = " : dir";
					}
					System.out.println(one+" : "+ff.exists()+result); // ff.exists() > 현재 파일의 경로
//					System.out.println(args[0]+": dir");
					// 파일이나 디렉토리명 :
				}
			}
		}
		else {
			System.out.println(args[0]+" 이름의 파일이나 디렉토리는 존재하지 않습니다.");
		}
		System.out.println(f.exists());
		try {
		System.out.println("기준경로 = "+f.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

