package com.basic;

public class OperatorTest3_ { //소스코드에 복사+붙여넣기하면 소스코드2 생성

	public static void main(String[] args) {
		//정수형 변수 2개 선언하고 값 저장하기
		//둘 중에 큰 수를 알아내서 변수에 담아 그 값을 출력
		int a = 7, b = 9;
		int bigger = (a > b)? a : b; //3항 연산자
		System.out.println(bigger);
		
		System.out.println(a/b);
	}

}
