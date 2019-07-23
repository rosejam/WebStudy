package com.ssafy;

public class Novel extends Book {
	private String genre;

	public Novel(String isbn, String title, String author, String publisher, int price, String desc, String genre) {
		super(isbn, title, author, publisher, price, desc);
		this.genre = genre;
	}

	public String toString() {
		return super.toString() + "\t\t| " + genre ;
	}
}