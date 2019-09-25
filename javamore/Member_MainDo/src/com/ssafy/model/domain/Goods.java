package com.ssafy.model.domain;

public class Goods {
	private int no;
	private String proname;
	private int proprice;
	private int quantity;
	private int total;
	public Goods() {}
	public Goods(int no, String proname, int proprice, int quantity, int total) {
		this.no = no;
		this.proname = proname;
		this.proprice = proprice;
		this.quantity = quantity;
		this.total = total;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return quantity*proprice;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("no=").append(no)
				.append(", proname=").append(proname)
				.append(", proprice=").append(proprice)
				.append(", quantity=").append(quantity)
				.append(", total=").append(getTotal());
		return builder.toString();
	}
}






