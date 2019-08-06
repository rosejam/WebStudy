package com.thread;
//Synchronization(동기화) : 멀티스레드에 의해 공유되는 자원에 lock을 거는 작업
public class SyncTest implements Runnable {

	public static void main(String[] args) {
		new SyncTest().go();  // 생성자가 호출
	}

	private void go() { //thread 생성 후 start
		Thread tom = new Thread(this, "tom");//러너블타겟, 이름(thread클래스의 .getName()으로 가져오는 이름)
		Thread jerry = new Thread(this, "jerry");//러너블타겟, 이름
		tom.start();
		jerry.start();
	}

	@Override
	public void run() {
		kitchen();
		bedroom();
	}

	private synchronized void bedroom() { //누가 이 메소드에 들어가면 다른 스레드는 못들어간다는 수식어 synchronized
		String name = Thread.currentThread().getName(); //Thread.currentThread(); 현재 이 줄을 실행중인 스레드를 리턴!!
		System.out.println(name+ " is in bedroom");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+ " is out bedroom");
	}

	private synchronized void kitchen() {
		String name = Thread.currentThread().getName();
		System.out.println(name+ " is in kitchen");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+ " is out kitchen");
	}
	
/*	tom is in kitchen
	tom is out kitchen
	jerry is in kitchen
	jerry is out kitchen
	jerry is in bedroom
	jerry is out bedroom
	tom is in bedroom
	tom is out bedroom 
	또는
	jerry is in kitchen
	jerry is out kitchen
	jerry is in bedroom
	jerry is out bedroom
	tom is in kitchen
	tom is out kitchen
	tom is in bedroom
	tom is out bedroom
	등 tom과 jerry의 순서는 정할 수 없음. 그러나 한 스레드는 run()순서대로 kitchen -> bedroom 방문
	*/
}
