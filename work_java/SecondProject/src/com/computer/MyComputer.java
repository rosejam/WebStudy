package com.computer;

public class MyComputer {
	//field:data 클래스안의 데이터를 또다른 클래스로 지정
	Monitor mon;
	Mouse mouse;
	KeyBoard key;
	MainFrame frame;
	
	//생성자
	public MyComputer() {
		mon = new Monitor(12.5 , "samsung", 3500000);
		//Monitor mon = new Monitor(12.5 , "samsung", 3500000); //생성자 안에 선언된 지역변수인 mon, 위에 필드의 mon은 생성되지않음
		mouse = new Mouse("logitec", true , 55000);
		key = new KeyBoard("abc" , "sun-mouse", 100000);
		frame = new MainFrame("intel" , "xyz", 5000000);
	}
	
	public void info() {
		mon.info();
		mouse.info();
		key.info();
		frame.info();
	}
	
	public void powerOn(){
		//monitor, frame의 전원 켜기
		mon.powerOn();
		frame.powerOn();
	}
	public void powerOff() {
		//monitor, frame의 전원 켜기
		mon.powerOff();
		frame.powerOff();
	}
	public void doJob() {
		//마우스 왼/오른쪽 클릭, 휠링 메소드 호출
		mouse.leftClick();
		mouse.rightClick();
		mouse.wheeling();
		//키보드 타입핑 메소드 호출
		key.keyType();
	}
	
	public static void main(String[] args) {
		MyComputer computer = new MyComputer();
		computer.powerOn();
		computer.doJob();
		computer.powerOff();
		computer.info();
	}

}
