package com.first;
// 1. 클래스 설계
public class TextFile {
	String name; 
	int size;
	String date;
	String type;
	String writer;
	
	void info() {
		System.out.println("TextFile [name=" + name + ", size=" + size + ", date=" + date + ", type=" + type 
				+ ", writer=" + writer + "]");
	}

}
