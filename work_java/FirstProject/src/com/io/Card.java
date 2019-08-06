package com.io;

import java.io.Serializable;

//신용카드 정보 저장을 위한 클래스. vo(value object) : 어떤 값을 저장하기 위한 용도의 클래스 - 어떤 작업을 하지 않음
//											private 필드, 생성자, 게터/세터 만 있음
//"스트림을 통해서 객체를 이동"시키기 위해서는 "Serialization(직렬화)"가 되어있어야 한다.
//	클래스 안의 데이터들이 바이트 배열 형식으로 묶여서 그룹핑 되는 것
public class Card implements Serializable { //implements Serializable붙이면 직렬화 된다. 추상메서드없으므로 작성할 필요X
	private int num;
	private String name;
	private String company;
	
	public Card(int num, String name, String company) {
		this.num = num;
		this.name = name;
		this.company = company;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
