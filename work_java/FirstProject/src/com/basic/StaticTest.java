package com.basic;
//static class Sclass{} //(StaticTest와 레벨이 같은)top-level class인 경우는 static 사용 안됨!!! error
public class StaticTest { //top-level class
	
	static class Sclass{} //inner class.내부 클래스는 static이 가능하다!!!
	
	static int scount; //0
	int count; //0
	
	static void hello() {
		System.out.println("static method...+ scount"); //+count는 사용불가. 객체생성되지 않았기 때문
	} //헬로월드 클래스에서 불러보았다.

	void hello2() {
		//static int num = 7; ////지역변수는 static안됨!//count가 생성될때엔 객체가 생성되었을 때인데 그 다음에 스태틱을 정의? 안돼
		System.out.println("static method...+ scount"); 
		System.out.println("non-static method...+ count"); //count가 생성될때엔 객체가 생성되어 hello2메서드도 이미 생성되었을 것이기 때문에 가능
	} //헬로월드 클래스에서 불러보았다.

	
	static { //static Block
		System.out.println("static block -1");
	}
	
	public static void main(String[] args) { //static method 내부에서는 this, super 키워드 사용 못함!!
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
