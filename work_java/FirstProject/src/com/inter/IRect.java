package com.inter;

public class IRect implements IShape{
	int w,h;
	
	public IRect(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}
	
	@Override
	public double getArea() {
		return  w * h;
	}

	@Override
	public double getCircum() {
		return 2 * (w+h);
	}

}