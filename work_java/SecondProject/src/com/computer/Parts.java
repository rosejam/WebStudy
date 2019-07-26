package com.computer;

public class Parts {
	String maker;
	int price;
	
	public Parts(String maker, int price) {
		this.maker = maker;
		this.price = price;
	}//부모인 Parts에 디폴트생성자가 없으므로 자동으로 만들어지지 않고 파라메터를 넣어주어야 생성된다.

	public void info() {
		System.out.println("maker:"+ maker);
		System.out.println("price:"+ price);
	}
}
