package com.ssafy;

public class TV extends Product {
	private int inch;

	public TV(int num, String name, int price, int left, int inch) {
		super(num, name, price, left);
		this.inch = inch;
	}
	
	public int getinch() {
		return inch;
	}

	public void setinch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return super.toString() + "TV [inch=" + inch + "]";
	}


}