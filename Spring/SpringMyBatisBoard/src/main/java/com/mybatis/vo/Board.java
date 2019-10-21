package com.mybatis.vo;
//vo(value object);board 테이블 안의 레코드 한 건을 위한 클래스
public class Board {
	
	private String num;
	private String name;
	private String title;	
	private String count;
	
	public Board() {}	
	
	public Board(String num, String name, String title) {
		this.num = num;
		this.name = name;
		this.title = title;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
}
