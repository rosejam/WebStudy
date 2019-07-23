package com.abst;
//추상 클래스 : 미완성이라 객체 생성(new)안됨
public abstract class Shape {
	abstract double getArea(); //추상 메소드 : {메소드 바디}가 없음
	abstract double getCircum(); 
	
	void test() {
		System.out.println("hello, abst...");
	}
}
