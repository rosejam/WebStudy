package com.basic;

public class StaticTest {
	
	static int scount; //0
	int count; //0
	
	static void hello() {
		System.out.println("static method...");
	} //헬로월드 클래스에서 불러보았다.
	
	static { //static Block
		System.out.println("static block -1");
	}
	
	public static void main(String[] args) {
		System.out.println(StaticTest.scount); //"객체 생성 없이" "클래스 이름으로 사용"!!!!
		
/*		StaticTest s1 = new StaticTest();
		StaticTest s2 = new StaticTest();
		StaticTest s3 = new StaticTest(); //생성하는 객체마다 count는 따로 생성되지만, scount는 모두 C.A.의 같은 변수를 참조한다.
		
		System.out.println(++s1.count + "--" + ++s2.count + "--" + ++s3.count);
		System.out.println(++s1.scount + "--" + ++s2.scount + "--" + ++s3.scount);*/

	}
	static { //static Block : main보다 먼저 실행된다.
		System.out.println("static block -2");
	}
}
