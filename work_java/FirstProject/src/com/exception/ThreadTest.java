package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//InterruptedException : Checked Exception(체크가 되어야 하는 예외) try~catch로 처리해야 함
public class ThreadTest {

	public static void main(String[] args) {
		//Thread t = new Thread(); //필요없음
		
		try {
			//t.sleep(3000);//프로그램 실행을 주어진 시간(ms)동안 멈추는 메소드
			Thread.sleep(3000); //sleep이 스태틱메소드!인것을 보고 "객체생성없이 클래스이름.메서드이름();"으로 바꿔주었다.
		} catch (InterruptedException e) { //sleep도중에 인터럽트가 발생하는 익셉션
			e.printStackTrace();
		} 
		System.out.println("hello, world...");
		
		///
		
		try {
			FileInputStream fis = new FileInputStream("HELLO.txt");//파일에서 내용을 읽어오는 파이프
		} catch (FileNotFoundException e1) { //이 파일이 없으면 어떡하느냐
			System.out.println(111);
			e1.printStackTrace(); //예외처리가 잘 되어도 익셉션 내용이 빨갛게 출력
		} 
																
		
		
	}

}
