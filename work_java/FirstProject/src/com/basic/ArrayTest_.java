package com.basic;

public class ArrayTest_ {

	public static void main(String[] args) {
		//int[] a; //선언
		//a = new int[3]; //생성
		int[] a = new int[3]; //선언+생성
		//int[] a2 = {100, 200, 300}; // 선언+생성+초기화
		a[0] = 100; //사용
		a[1] = 200;
		a[2] = 300;
		
		//배열안의 값 처리
//		for(int i = 0; i < a.length; i++) { //a.length는 a배열이 몇칸(3)짜리인지 이다~~~
//			System.out.println(a[i]);
//		}
		for(int x : a) { //inhanced for
			System.out.println(x);
		}
		
		
		boolean[] flag = {true, false, false}; //배열의 선언, 초기화를 한번에
		for(boolean value: flag) { //inhanced for문 : flag배열 안의 값을 하나씩 value변수(boolean타입)에 대입
			System.out.println(value);
		}

	}

}
