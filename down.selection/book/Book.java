package com.book;

import java.io.Serializable;

public class Book implements Serializable{

	/**
	 *
	 */
	
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	private int quantity;



	public Book(String isbn, String title, String author, String publisher, int price, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.quantity = quantity;
	}



	public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
		this(isbn, title, author, publisher, price, quantity);
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%s\t|%s\t|%s\t|%-10s|%10d|%-10s|%10d",isbn, title, author, publisher, price, desc, quantity);
	}
}
