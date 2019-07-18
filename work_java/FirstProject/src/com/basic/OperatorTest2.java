package com.basic;

public class OperatorTest2 { //소스코드에 복사+붙여넣기하면 소스코드2 생성

	public static void main(String[] args) {
		//논리연산자(정수형 데이터 대상)  --> 정수형은 비트단위로 논리연산
		int e = 3, f= 5;
		System.out.println(e & f);
		System.out.println(e | f);
		System.out.println(e ^ f); 
		
		
		
		//논리연산자(논리형 데이터 대상)
		boolean a = true, b = false, c= false;
		System.out.println(a && b); //&& and(2개짜리는 short-cut logic으로 더 빠름)
		System.out.println(b==false & c==false);
		System.out.println(a || b); //|| or(short-cut logic)
		System.out.println(a ^ b); //xor(다르면 참)
		
		
		int A = 3, B = 5;
		if(A++>4 && ++B>2) {
		}
		//A = 4, B = 5 앞이 false여서 뒤는 실행X(만약 &&아니고 &이면 뒤부분의 코드가 실행되어서 B = 6이된다~)
		
		
		boolean g = true;
		System.out.println(!g); //not

	}

}
