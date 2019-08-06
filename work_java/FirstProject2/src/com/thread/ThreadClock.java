package com.thread;

import java.util.Date;

public class ThreadClock implements Runnable {
	public ThreadClock() { //thread 생성 후 start
		Thread t = new Thread(this); //자기 자신이 run()메소드를 가지고 있음 
										//this, 즉 ThreadClock의 run()을 실행
		t.start();
		
	}
	public static void main(String[] args) {
		new ThreadClock(); //객체를 생성만 하고 그 이름으로 뭐 할게 없을 때 이렇게 작성
	}
	
	
	//thread가 해야 할 내용을 가진 메소드:1초 간격으로 화면에 시간을 출력
	@Override
	public void run() {
		while(true) { //무한루프. 그러나 시간은 1초간격
			Date d = new Date(); //객체 생성 시에 시스템에서 날짜(+시간)정보를 받아옴.
			System.out.println(d);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
