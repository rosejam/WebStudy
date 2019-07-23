package com.object;

public class OverloadingTest {
	int num;
	
	public OverloadingTest(int num) { //생성자
		super();
		this.num = num; //t.num = 100; 으로 할 수 없다 t는 메인메서드 안에서 선언된것이기 때문~ -> this를 사용
	}
	
	//메서드 overloading : 한 클래스 안에서 메소드 이름은 동일 하고 "파라메터 리스트"(타입 등)가 다른 것
	int add(int a, int b) {
		return a+b;
	}
	double add(double a, double b) {
		return a+b;
	}
	public static void main(String[] args) { //메인 메서드
		OverloadingTest t = new OverloadingTest(100);
		System.out.println(t.add(11, 12));
		System.out.println(t.add(11.5, 12.9));

	}

}
