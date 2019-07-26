package com.first;
// 1. 클래스 설계
public class TextFile {
	String name; 
	int size;
	String date;
	String type;
	String writer;
	
	TextFile(){} //디폴트 생성자
	
	public TextFile(String name, int size, String date, String type, String writer) {
		super();
		this.name = name;
		this.size = size;
		this.date = date;
		this.type = type;
		this.writer = writer;
	}
	
	void info() {
		System.out.println("TextFile [name=" + name + ", size=" + size + ", date=" + date + ", type=" + type 
				+ ", writer=" + writer + "]");
	}


}
