package com.tier3;
//<VO>: customer table 안의 레코드 1건의 정보를 저장하기 위한 객체
public class Customer { //필드, 생성자, 게터세터, 투스트링
	private String num;
	private String name;
	private String address;
	
	public Customer() {} //default 생성자 꼭 넣기! : 프레임워크가 이용함
	public Customer(String num, String name, String address) { //사용할 생성자 만들기
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
