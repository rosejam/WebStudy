package com.ssafy;

import java.io.Serializable;

public class Magazine extends Book  implements Serializable{ //»©µµµÇ³ª?
	private int month;
	
	public Magazine(String isbn, String title, int price, int quantity,
			int month) {
		super(isbn, title, price, quantity);
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return super.toString()  + ", month=" + month + "}";
	}
	
	
	
}
