package com.object;

public class Rect {
	int width; 
	int height;
	
	int getArea() {
		return width*height;
	}
	int getCircum() {
		return 2*(width+height);
	}
	public static void main(String[] args) {
		Rect a = new Rect();
		Rect b = new Rect();
		
		a.width = 2;
		a.height =3;
		b.width = 4;
		b.height = 5;
		
		
		System.out.println(a.getArea());
		System.out.println(b.getArea());
		System.out.println(a.getCircum());
		System.out.println(b.getCircum());

	}

}
