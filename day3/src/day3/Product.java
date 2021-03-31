package day3;
// 객체의 정보를 저장하는 클래스 - private 변수 / public setter/getter 메서드를 설정할 것
class Product { //source > Generate getters and setters
	private int code;
	String productName;
	private double price;
	private int balance;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
