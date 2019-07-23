package com.abst;

public class Circle extends Shape {
	int r; //클래스 안의 필드는 기본값.
	
	public Circle(int r) {
		this.r = r;
	}

	@Override
	double getArea() { //원면적
		return Math.PI *r*r;
	}

	@Override
	double getCircum() { //원둘레
		return 2* Math.PI *r;
	}
	
}
