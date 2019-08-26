package com.ssafy;

public class TV extends Product {
	private String tv_info;

	public TV(int num, String name, int price, int left, String tv_info) {
		super(num, name, price, left);
		this.tv_info = tv_info;
	}
	
	public String getTv_info() {
		return tv_info;
	}

	public void setTv_info(String tv_info) {
		this.tv_info = tv_info;
	}

	@Override
	public String toString() {
		return super.toString() + "TV [tv_info=" + tv_info + "]";
	}


}