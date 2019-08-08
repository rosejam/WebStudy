package com.thread;
//1. Thread 클래스를 상속받아 thread 생성
class Tiger extends Thread { //Tiger는 Thread객체이다~ 또한 Runnable(객체)이기도 하다.
	//run()은 "callback 메소드" : 
	//직접 호출되지는 않지만 특정 조건(start()호출되는 것)이 되면 자동호출(자동실행)되는 메소드
	public void run() { //thread가 해야할 작업 내용을 가지고 있는 메서드 run()
		System.out.println(getName()+" is running... Tiger"); //Thread클래스에서 "실행중인 스레드 이름을 출력해주는 메서드 getName()"
	}
}

public class TigerTest {
	public static void go() {
		System.out.println("gogogo");
	}
	
	public static void main(String[] args) { //main스레드가 실행
		go(); //main스레드가 실행하는 스태틱 메서드
		Tiger t1 = new Tiger(); //t1은 생성된 스레드이다~
		t1.start(); //thread 작업 시작을 알리는 메소드 start() //t1이 Tiger클래스의 run()메서드를 찾으러간다!!
		Tiger t2 = new Tiger();
		t2.start();
		Tiger t3 = new Tiger();
		t3.start(); //t3스레드가 Tiger의 run()을 실행하러 감 - "run()을 간접적으로 호출" - run은 callback메소드
		t3.run(); //main스레드가 Tiger의 run()을 "직접 호출해서 실행"
		
	}//실행해보면 스레드 순서가 막 섞임(자바에서는 thread 순서 보장하지 않는다)

}
