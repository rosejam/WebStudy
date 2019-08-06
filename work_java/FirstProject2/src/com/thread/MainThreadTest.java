package com.thread;

public class MainThreadTest implements Runnable {

	@Override
	public void run() { //thread의 작업 내용이 들어 있는 메소드
		System.out.print("run by thread...");
		Thread tt = Thread.currentThread();
		System.out.println(tt.getName()+" is running...");
	}
	
	public void go() { 
		System.out.println("method go...run by main");
	}
	
	public MainThreadTest() { //디폴트 생성자. Thread 생성후에 start 2.
		Thread t = new Thread(this, "tommy"); //Runnable객체인 m을 가리킴.
		t.start();
		try {
			t.join(); //스레드t가 작업을 마치고 죽을 때까지 다른 스레드 ex)main스레드 등 은 기다려 달라 
		} catch (InterruptedException e) { //(방해전까지)
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MainThreadTest m = new MainThreadTest(); //1.
		m.go(); //3.원래는!!메인 스레드가 실행하므로 생성자안의 t.start()-사용자 정의 스레드보다 우선순위가 높다!!
	}
}
