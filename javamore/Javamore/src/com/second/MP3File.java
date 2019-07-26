package com.second;

public class MP3File extends File {

	String singer;
	
	public MP3File(String name, int size, String date, String type, String singer) {
		super(name, size, date, type);
		this.singer = singer;
	}

	void info() {
		super.info(); ////부모의 info() 호출해서 공통의 데이터 출력 부탁 
		System.out.println("singer=" +singer);
		System.out.println();
	}

}
