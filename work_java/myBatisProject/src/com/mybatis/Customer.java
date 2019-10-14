package com.mybatis;
//vo : 테이블(customer) 안의 레코드 한 건의 정보를 담기 위한 목적의 객체
public class Customer {
	private String num;
	private String name;
	private String address;
	
	public Customer() {}
	
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
		//System.out.println("setNum");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		//System.out.println("setName");
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		//System.out.println("setAddress"+address);
	}
	
}
