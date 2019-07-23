package com.ssafy;

public class Novel extends Book {
	private String genre;

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public String toString() {
		return super.toString() + "\t\t| " + year + "." + month ;
	}
}