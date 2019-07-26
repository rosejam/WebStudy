package com.second;

public class File {
	String name; 
	int size;
	String date;
	String type;
	
	//생성자를 만들었으므로 default는 안 만들어짐 -> 빈 괄호로는 new 불가해짐 
	public File(String name, int size, String date, String type) {
		this.name = name;
		this.size = size;
		this.date = date;
		this.type = type;
	}
	
	void info() {
		System.out.println("name=" + name);
		System.out.println("size=" + size);
		System.out.println("date=" + date);
		System.out.println("type=" + type);
	}

}
