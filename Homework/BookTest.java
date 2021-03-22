class Book{
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	@Override
	public String toString() {
		return isbn+"   | "+title+"   | "+author+"   | "
				+publisher+"   | "+price+" "+desc;
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
		
		return String.format(isbn+"   | "+title+"  "+author+"   | "
				+publisher+"   | "+price+"    | "+year+"."+month+desc);
	}
}

public class BookTest {
	
	public static void main(String[] args) {
		System.out.println("******************** 도서목록  ********************");
		Book b1 = new Book("21424","Java Pro","김하나","Jaen.kr",15000,"기본문법");
		System.out.println(b1.toString());
		Book b2 = new Book("35355","OOAD 분석, 설계","소나무","Jaen.kr",30000,"");
		System.out.println(b2.toString());
		Magazine m2 = new Magazine("35535","Java world", "편집부","androidjava.com",7000,2013,2,"");
		System.out.println(m2.toString());
	}
}
