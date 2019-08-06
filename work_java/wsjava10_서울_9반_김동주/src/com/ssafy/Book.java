package com.ssafy;

import java.io.Serializable;

public class Book implements Serializable,Comparable<Book> { //VO에선 5가지 체크 
	private String isbn;
	private String title;
	private int price;
	private int quantity;
	
	public Book(String isbn, String title, int price, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "{isbn=" + isbn + ", title=" + title 
				+ ", price=" + price  + ", quantity=" + quantity;
	}

	@Override
	public int compareTo(Book o) {
		if(this.getPrice()<o.getPrice()) return -1;
		else if(this.getPrice()==o.getPrice()) return 0;
		else return 1;
	}
	
}
