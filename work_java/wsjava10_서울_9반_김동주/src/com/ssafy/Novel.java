package com.ssafy;

import java.io.Serializable;

public class Novel extends Book  implements Serializable{
	private String genre;

	public Novel(String isbn, String title,int price, int quantity, String genre) {
		super(isbn, title, price, quantity);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString() + ", genre=" + genre + "}";
	}
	
}
