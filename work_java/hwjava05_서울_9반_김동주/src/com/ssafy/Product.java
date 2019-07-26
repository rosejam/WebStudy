package com.ssafy;

public class Product {
	private int num;
	private String name;
	private int price;
	private int left;
	
	public Product(int num, String name, int price, int left) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.left = left;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", left=" + left + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}
}