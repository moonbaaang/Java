package BookStoreTest;

class Book {
	private String title;
	private int price;

	Book(){	} // 기본생성자 생성 , 이후 오버라이딩
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}

	// Source 에서 Generate setter/getter로 한번에 만들 수 있음
	public String getTitle() {
		return title;
	}

	// setter 메소드는 리턴타입이 void 여도 된다.
	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
}

class BookMgr /*extends Object*/{
	Book booklist [] ; // new Book [n] 사용불가 (몇개를 생성하라는 내용이 따로 없다)
	BookMgr(Book [] booklist){
		this.booklist = booklist;
	}
	
	public String toString() { // toString() 오버라이딩!!
		String result = ""; 
		int totalPrice = 0;
		//booklist 배열 저장 객체수만큼 반복    | 이름
		for (int i=0; i<booklist.length;i++) {
			result += String.format("%-20s"+"|",booklist[i].getTitle())+booklist[i].getPrice()+"\n";
			totalPrice += booklist[i].getPrice();
		}
		result += "전체 책 가격의 합 : "+totalPrice;
		return result;
	}
}

public class BookStore {

	public static void main(String[] args) {
		// 5개의 book객체를 저장하는 배열
		Book booklist[] = new Book[5]; 
		// 4개의 북 객체를 생성 (책제목, 가격)
		Book book1 = new Book("Java Program", 25000);
		Book book2 = new Book("JSP Program", 15000);
		Book book3 = new Book("SQL Fundamentals", 30000);
		Book book4 = new Book("JDBC Program", 28000);
		Book book5 = new Book();
		// 1개 객체 기본생성자
		book5.setTitle("Spring Program");
		book5.setPrice(34000);
		booklist[0] = book1;
		booklist[1] = book2;
		booklist[2] = book3;
		booklist[3] = book4;
		booklist[4] = book5;
		
		BookMgr mgr = new BookMgr(booklist);
		System.out.println("=== 책 목록  정보 ===");
		System.out.println(mgr/*.toString()*/); 

	}

}

/*
[실행결과]

=== 책 목록  정보 ===
Java Program        	 | 25000
JSP Program         	 | 15000
SQL Fundamentals    	 | 30000
JDBC Program        	 | 28000
Spring Program      	 | 34000
전체 책 가격의 합 : 132000

 */
