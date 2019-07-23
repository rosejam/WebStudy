package com.object;

public class Circle {
	//field
	int radius;
	
	//생성자("하나도 안만들어놓는 경우" , Circle(){}꼴의 아무것도 없는 default생성자가 자동으로 추가됨!)
	
	public Circle(int radius){
		this.radius = radius; //클래스필드 = 파라메터
	}
	
	//method
	double getArea() {
		return 3.14*radius*radius;
	}
	double getCircum() {
		return 3.14*2*radius;
	}
	public static void main(String[] args) { //메인함수에서 객체생성 및 사용
//		Circle c = new Circle(); 
//		c.radius = 3;
		Circle c = new Circle(3); //디폴트가 아닌 따로 만든 생성자를 사용해야 한다.
		
		System.out.println(c.getArea());
		System.out.println(c.getCircum());

	}
}
