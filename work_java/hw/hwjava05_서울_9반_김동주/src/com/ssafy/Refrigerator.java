package com.ssafy;

public class Refrigerator extends Product {
	private String refrig_info;

	public Refrigerator(int num, String name, int price, int left, String refrig_info) {
		super(num, name, price, left);
		this.refrig_info = refrig_info;
	}
	
	public String getRefrig_info() {
		return refrig_info;
	}

	public void setRefrig_info(String refrig_info) {
		this.refrig_info = refrig_info;
	}

	@Override
	public String toString() {
		return super.toString()+"Refrigerator [refrig_info=" + refrig_info + "]";
	}
}