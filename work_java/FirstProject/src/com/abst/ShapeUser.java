package com.abst;

public class ShapeUser {

	public static void main(String[] args) {
		Shape[] s = new Shape[3]; // 
		//Shape a = new Shape(); //Shape 타입은 생성이 안돼..
		s[0] = new Circle(8);
		s[1] = new Rect(8, 12);
		s[2] = new Circle(13); //s는 "부모타입인 shape의 배열"이므로, "생성된 자식 타입들"은 모두 "대입"이 잘 된다!
		
		for(Shape x :s) {
			System.out.println(x.getClass().getSimpleName()); //클래스이름만.
			System.out.println("면적:"+ x.getArea());
			System.out.println("둘레:"+ x.getCircum());
			System.out.println("---------------------------");
		}
		
	}

}
