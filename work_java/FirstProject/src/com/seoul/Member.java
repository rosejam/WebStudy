package com.seoul;

public class Member {
	//field 
	private int num;
	private String name;
	private String address;
	
	//method : getter & setter
/*	public void setNum(int num) { //세터
		this.num = num;
	}
	public int getNum() { //게터
		return num;
	}*/
	//source에서 간단히 생성
	public int getNum() {
	//	if(권한체크) 통과되면 값을 넘겨줌
		return num;
	}
	public void setNum(int num) {
		if(num>0) //양수면 값을 넣어줌 등, 메소드를 통해서만 데이터에 접근 가능하도록 한다.
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
	
}
