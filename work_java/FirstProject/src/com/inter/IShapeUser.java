package com.inter;

public class IShapeUser {

	public static void main(String[] args) {
		IShape[] is = new IShape[3];
		is[0] = new ICircle(5);
		is[1] = new ICircle(6);
		is[2] = new IRect(3,8); //자식들을 생성
		
	}

}
