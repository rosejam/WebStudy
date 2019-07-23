package com.object;

public class CarTest {
	public static void main(String[] args) { 
		Car c1 = new Car(); //클래스 이용해서 객체 생성
		Car c2 = new Car(7833);
		Car c3 = new Car(8907, "morning") ;
		Car c4 = new Car(6899, "grandeur", "tommy"); //객체를 생성하고, 파라메터가 있는 아래쪽의 생성자가 실행됨!!!

		//객체 사용
//		c1.model = "K5";
//		c1.owner = "kim";
//		c1.num = 1234;
		
		c1.info(); 
		c2.info();
		c3.info();
		c4.info();
		
	}
}
