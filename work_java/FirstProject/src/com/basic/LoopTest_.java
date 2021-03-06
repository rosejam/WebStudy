package com.basic;

public class LoopTest_ {

	public static void main(String[] args) {
		// for
		for(int i = 0; i < 5; ++i) { //조건식에서 i++ 나 ++i나 동일하게 작동, 초기값에서 타입 표기해줘야함
			if(i ==3) 
				continue; //조건이 맞을 때 컨티뉴는 반복작업을 skip하고 "다음 i"로 가서 반복작업 수행
				//break; //조건이 맞을 때 브레이크는 반복작업을 벗어남 "stop"
				//불필요한 반복작업을 줄임ㄴ
			System.out.println(i + ". hello");
		}
		System.out.println("-----------------------------");
		
		//while
		int j = 0; //초기값
		while(j++ < 5) { //조건식 (j++ <5로 조건식과 증감식을 한줄로 적을 수 있음)
			System.out.println(j + ". hello");
			//j++; //증감식 : 이부분이 없으면 무한루프가 됨(서버 등에서 활용)
		}
		System.out.println("-----------------------------");
		//do~while
		int k = 10; //초기값
		do { //조건이 안맞아도 일단 한번 실행하기
			System.out.println(k + ". hello");
			k++; //증감식
		}while(k < 5); //조건식
	}

}
