package com.second;
// 1. 클래스 설계
public class TextFile extends File {

	String writer;
	
	//TextFile(){} //디폴트 생성자
	
	public TextFile(String name, int size, String date, String type, String writer) {
		super(name, size, date, type); //"부모 생성자 호출"(부모가 생성됨)
//		this.name = name;
//		this.size = size;
//		this.date = date;
//		this.type = type;
		this.writer = writer; //이건 자식이 추가한 데이터
	}
	
	void info() {
		super.info(); ////부모의 info() 호출해서 공통의 데이터 출력 부탁 
		System.out.println("writer=" + writer);
		System.out.println();
	}


}
