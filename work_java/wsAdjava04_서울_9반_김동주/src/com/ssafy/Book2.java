package com.ssafy;

public class Book2 extends Book{
	private String title;
	private String publisher;
	private int price;
	private String author;
	
	public Book2() {
	}
	public Book2(String title, String publisher, int price, String author) {
		super();
		this.title = title;
		this.publisher=publisher;
		this.price = price;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book2 [title=" + title + ", publisher=" + publisher + ", price=" + price + ", author=" + author + "]";
	}

}