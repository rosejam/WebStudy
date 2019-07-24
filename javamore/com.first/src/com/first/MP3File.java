package com.first;

public class MP3File {
	String name; 
	int size;
	String date;
	String type;
	String singer;
	
	void info() {
		System.out.println("MP3File [name=" + name + ", size=" + size + ", date=" + date + ", type=" + type + ", singer=" + singer
				+ "]");
	}

}
