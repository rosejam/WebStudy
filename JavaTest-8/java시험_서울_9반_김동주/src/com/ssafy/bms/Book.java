package com.ssafy.bms;

import java.io.Serializable;

public class Book implements Serializable, Comparable<Book> {
	private String isbn;
	private String title;
	private String author;
	private int price;
	
	public Book() {};
	
	public Book(String isbn, String title, String author, int price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	@Override //ISBN오름차순 정렬용으로 추가함!!
	public int compareTo(Book o) {
		if(Integer.parseInt(this.getIsbn().replace("-", "")) < Integer.parseInt(o.getIsbn().replace("-", ""))) return -1;
		else if(Integer.parseInt(this.getIsbn().replace("-", "")) == Integer.parseInt(o.getIsbn().replace("-", ""))) return 0;
		else return 1;
	}

	
	
	
}
