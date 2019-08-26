package com.ssafy;

import java.io.Serializable;

public class Refrigerator extends Product implements Serializable {
	private int liter;

	public Refrigerator(int num, String name, int price, int left, int liter) {
		super(num, name, price, left);
		this.liter = liter;
	}
	
	public int getliter() {
		return liter;
	}

	public void setliter(int liter) {
		this.liter = liter;
	}

	@Override
	public String toString() {
		return super.toString()+", liter=" + liter + "}";
	}
}