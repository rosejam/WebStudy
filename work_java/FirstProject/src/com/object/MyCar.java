package com.object;

public class MyCar {
	int num =1234;
	String color ="red";
	int year = 2019;
	String model = "x5";
	
	
	
	public static void main(String[] args) {
		MyCar m = new MyCar();
		System.out.println(m); //레퍼런스만 찍어도 toString이 호출되므로 아래줄과 같은 출력이 나온다.
		System.out.println(m.toString()); //부모인 Object에서 가져다쓸수 있는 to String, 패키지.클래스@Hex Hash code 주소값.
		
	}



	@Override //Generate toString 으로 클래스의 필드를 모두 출력하는 메서드를 만들어줌!
	public String toString() {
		return "MyCar [num=" + num + ", color=" + color + ", year=" + year + ", model=" + model + "]";
	}

//	//toString() Overriding
//	@Override
//	public String toString() {
//		return "MyClass -> 2019년 7월 23일. 작성자: 홍길동.  내차 정보를 가지고 있는 클래스.";
//	}
	

}
