package com.basic;

public class HelloWorld { //클래스수식어 class(=부품) 클래스이름
	/*"main"메소드(=함수) : 클래스의 "실행"을 위해서 꼭 필요한 부분이다. 
	실행이 되는 클래스가 실행이 안되는 클래스의 기능을 가져다 쓰기도 함.*/
	public static void main(String[] args) { //메인 메소드는 이 형식을 갖춰야함
		String name = "tommy"; //변수
		System.out.print("hello,"+ name); //"모니터(콘솔)"에 출력하는 문장 -->"표준출력" (표준입력은 키보드)
		//System.out.println(); //sysout + <좌컨트롤+스페이스>단축키
		System.out.println(123); //줄바꿈(ln)
	}

}
