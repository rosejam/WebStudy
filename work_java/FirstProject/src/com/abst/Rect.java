package com.abst;

public class Rect extends Shape {
	int a, b; 
	
	public Rect(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	double getArea() { 
		return a*b;
	}

	@Override
	double getCircum() { 
		return 2*(a+b);
	}
	
}