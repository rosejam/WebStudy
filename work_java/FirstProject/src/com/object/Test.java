package com.object;

public class Test {

	public static void main(String[] args) {
		int a = 7 ; //메인method 안에서만 사용 가능한 지역변수
		
		first(); //메소드가 없는상태라면 자동으로 만들 수 있다. 
		second();
		third(); //스택에 순서대로 쌓임

	}

	private static void third() {
		int a = 17;
		
	}

	private static void second() {
		int a = 27;
		
	}

	private static void first() {
		int a = 37;
		
	}

}
