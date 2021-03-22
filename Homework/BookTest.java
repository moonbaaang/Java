import java.util.ArrayList;

class Book{
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return String.format("%-7s| %-15s| %-5s| %-15s| %5d | %s",
				isbn, title, author, publisher, price, desc);
	}
}

class Magazine{
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private int year;
	private int month;
	String desc;
	
	public Magazine(String isbn, String title, String author, 
			String publisher, int price, int year, int month,String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		
		return String.format("%-7s| %-15s| %-5s| %-15s| %5d | %-10s| %d.d",
				isbn, title, author, publisher, price, desc, year, month);
	}
}

public class BookTest {
	public static void main(String[] args) {
		Book booklist[] = new Book[5];
		Book b1 = new Book("21424","Java Basic", "김하나","Jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("33455", "JDBC Pro", "김철수", "Jaen.kr", 23000, "");
		Book b3 = new Book("55355", "Servlet/Jsp","박자바","Jaen.kr", 41000, "Model2 기반");
		Book b4 = new Book("35332", "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight Framework");
		Book b5 = new Book("35355", "OOAD 분석,설계", "소나무", "Jaen.kr", 30000, "");
		
		booklist[0] = b1;
		booklist[1] = b2;
		booklist[2] = b3;
		booklist[3] = b4;
		booklist[4] = b5;
		
		Magazine magazinelist[] = new Magazine[5];
		Magazine m1 = new Magazine("35535", "Java World", "편집부", "Jaen.kr", 7000, 2013, 2, "");
		Magazine m2 = new Magazine("33434", "Mobile World", "편집부", "Jaen.kr", 8000, 2013, 8, "");
		Magazine m3 = new Magazine("75342", "Next Web", "편집부", "Jaen.kr", 10000, 2012, 10, "AJAX 소개");
		Magazine m4 = new Magazine("76543", "Architexture", "편집부", "Jaen.kr", 5000, 2010, 3, "java 시스템");
		Magazine m5 = new Magazine("76534", "Data Modeling", "편집부", "Jaen.kr", 14000, 2012,12, "");
		
		magazinelist[0] = m1;
		magazinelist[1] = m2;
		magazinelist[2] = m3;
		magazinelist[3] = m4;
		magazinelist[4] = m5;
		
		System.out.println("******************** 도서목록  ********************");
		for(int i = 0; i<5 ; i++) {
			System.out.println(booklist[i].toString());
		}
		System.out.println("******************** 도서목록  ********************");
		for(int i = 0; i<5 ; i++) {
			System.out.println(magazinelist[i].toString());
		}
	}
}
