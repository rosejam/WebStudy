package com.dao;
//VO:customer table 안의 레코드 한건의 정보를 저장하기 위한객체

public class Customer {
	private String num;
	private String name;
	private String address;	
	
	public Customer() {}//default 생성자	
	
	public Customer(String num, String name, String address) {
		this.num = num;
		this.name = name;
		this.address = address;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [num=" + num + ", name=" + name + ", address=" + address + "]";
	}
}
