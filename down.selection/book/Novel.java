package com.book;

public class Novel extends Book{
	String genre;
	public Novel(String isbn, String title, String author, String publisher, int price, String desc, int quantity, String genre) {
		super(isbn, title, author, publisher, price, quantity);
		this.genre=genre;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Novel [genre=" + genre + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
