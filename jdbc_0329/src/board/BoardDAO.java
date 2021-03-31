package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDAO {
	public void insertBoard(BoardDTO dto) {
		//select sql작성
				Connection con = null;
				PreparedStatement pt = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection
						("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
					System.out.println("DB 연결 성공");
					String insertSQL = 
							"insert into board values(board_seq.nextval, ?, ?, ?, sysdate, ? ,0)";
					pt = con.prepareStatement(insertSQL);				
					
					pt.setString(1, dto.getTitle());
					pt.setNString(2, dto.getContents() );
					pt.setNString(3,  dto.getWriter());
					pt.setInt(4, dto.getPassword());
//					pt.setInt(5,  0);//조회수
					
					int cnt = pt.executeUpdate();  //cnt == 1
					System.out.println(cnt + "  개의 글 저장 완료");
					
				}catch(ClassNotFoundException e) {
					System.out.println("Check driver setting!!!");
				}catch(SQLException e) {
					System.out.println("Check DB connection!!!");
					e.printStackTrace();
				}finally{
					try {
						pt.close();
						con.close();
						System.out.println("DB연결 해제");
					} catch(SQLException e) {}
				}
			} // getBoardlist end
			
	
	public ArrayList<BoardDTO> getBoardList() {
		//select sql작성
				Connection con = null;
				PreparedStatement pt = null;
				ResultSet rs = null;
				ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection
						("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
					System.out.println("DB 연결 성공");
				
					String selectSQL = "select * from board order by time desc";
					pt = con.prepareStatement(selectSQL);
					rs = pt.executeQuery(); //첫번째 레코드 이전에 위치하고있음
					
					while(rs.next()) { //게시물번호 제목 작성자 조회수
						BoardDTO dto = new BoardDTO();
						dto.setSeq(rs.getInt("seq"));
						dto.setTitle(rs.getString("title"));
						dto.setWriter(rs.getString("writer"));
						dto.setViewcount(rs.getInt("viewcount"));
						list.add(dto);
					}
					
				}catch(ClassNotFoundException e) {
					System.out.println("Check driver setting!!!");
				}catch(SQLException e) {
					System.out.println("Check DB connection!!!");
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						pt.close();
						con.close();
						System.out.println("DB연결 해제");
					} catch(SQLException e) {}
				}
				return list;
			} // getBoardlist end
			
	public ArrayList<BoardDTO> getBoardList(int pageNum, int cntPerPage) {
				//select sql작성
				Connection con = null;
				PreparedStatement pt = null;
				ResultSet rs = null;
				ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection
						("jdbc:oracle:thin:@127.0.0.1:1521:xe", "jdbc", "jdbc");
					System.out.println("DB 연결 성공");
					
					// pageNum = 1 , cntPerPAge = 5 > 1-5
					// pageNum = 2 , cntPerPAge = 5 > 6-10
					
					
					String selectSQL = 
							"select seq, title, writer, viewcount"
							+ " from (select rownum r, seq, title, writer, viewcount"
							+ " from (select * from board order by time desc)"
							+ ")"
							+ " where r between ? and ?";
					
					pt = con.prepareStatement(selectSQL);
					pt.setInt(1, (pageNum-1)*cntPerPage+1);
					pt.setInt(2, pageNum*cntPerPage);
					
					rs = pt.executeQuery(); //첫번째 레코드 이전에 위치하고있음
					
					while(rs.next()) { //게시물번호 제목 작성자 조회수
						BoardDTO dto = new BoardDTO();
						dto.setSeq(rs.getInt("seq"));
						dto.setTitle(rs.getString("title"));
						dto.setWriter(rs.getString("writer"));
						dto.setViewcount(rs.getInt("viewcount"));
						list.add(dto);
					}
					
				}catch(ClassNotFoundException e) {
					System.out.println("Check driver setting!!!");
				}catch(SQLException e) {
					System.out.println("Check DB connection!!!");
					e.printStackTrace();
				}finally{
					try {
						rs.close();
						pt.close();
						con.close();
						System.out.println("DB연결 해제");
					} catch(SQLException e) {}
			}
			return list;
		} // getBoardlist end
}



