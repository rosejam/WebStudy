package com.thread;
//2. Runnable을 implements 하는 경우 -> 별도로 Thread객체를 생성하면서 Runnable객체를 인자로 전달해 주어야함
class Lion implements Runnable { //Lion은 Runnable타입이다~ 얘도 부모자식 관계
	@Override //인터페이스이므로 오버라이딩해주어야함
	public void run() {
		String name = Thread.currentThread().getName();
		Thread t = Thread.currentThread(); //현재 실행중인 thread를 알아냄
											//스태틱메서드 이므로 클래스이름Thread.메서드();
		System.out.println(t.getName()+" = "+name+" is running... Lion"); //Thread.currentThread().getName()과 동일
																		//러너블 인터페이스에 없는 메서드 이므로 그냥 쓸 수 없음
	}
}

public class LionTest {

	public static void main(String[] args) {
		Lion l1 = new Lion(); //l1은 "thread가 아님. Runnable 객체임"(=Runnable을 구현한 객체)!!
								//하지만 thread가 무슨 작동을 하는지 표현한 run() 메서드는 가지고 있음!!
		Thread t1 = new Thread(l1); //생성자의 파라메터로 Runnable객체를 Runnable target으로 넣어준다!! 
									//넣어준 객체의 run()을 찾아 실행
									//"Lion l1의 run()을 찾아 실행"하게 됨
		t1.start();
		
		Lion l2 = new Lion(); 
		Thread t2 = new Thread(l2); //"Lion l2의 run()을 찾아 실행"하게 됨
		t2.start();
		
		Thread t3 = new Thread(new Tiger()); //Tiger의 run()을 찾아 실행하게 됨 //Tiger는 Runnable(객체)이기도 하다.
		t3.start();
		
		Thread t4 = new Thread(l1); //"Lion l1의 run()을 찾아 실행"하게 됨
		t4.start();
		
		//////////////Anonymous Class
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("나는 무명 클래스...");
			}
		}).start(); //스레드 t5를 무명인터페이스를넣고 바로 start시킴.
		/////////////
	}

}
