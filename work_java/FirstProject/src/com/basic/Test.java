package com.basic;

import java.util.Scanner; //Scanner메서드를 사용하기 위해 import

public class Test {

	public static void main(String[] args) {
		//System.in : 표준입력(키보드입력) -- 문자가 아닌 "코드"로 인식
		//Scanner : 표준입력값을 받아와서 처리해주는 유틸리티 클래스 -- 코드가 어떤 문자의 입력이었는지
		Scanner s = new Scanner(System.in);
		System.out.println("입력하세요:");
		int a = s.nextInt(); //scanner로 인식된 문자를 int형으로 받아옴 ex)nextLine은 줄단위로 스트링을 받아옴
		
		System.out.println("입력하세요:");
		int b = s.nextInt();
		
		System.out.println(a);
		System.out.println(b);
	}

}
