package com.basic;

public class MethodTest {
	//main메서드바깥에 다른 메서드들을 "정의"
	//add(): int형 변수 2개를 입력받아 그 합을 리턴해주는 메서드
	static int add(int a, int b) { 
		int c = a + b;
		return c;
	}
	//increase(): int형 변수 1개를 입력 받아 10을 더한 후 출력해 주는 메소드(리턴을 하지는 않음)
	static void increase(int x) {
		System.out.println(x + 10);
	}
	public static void main(String[] args) { //public static는 메서드의 수식어
		// main메서드 내부에서 사용자 정의 메소드들을 사용하는 부분
		int result = add(3, 8);
		System.out.println(result);
		//System.out.println(add(3, 8));해도 됌
		increase(55);
	}
	//main바깥
	
}
