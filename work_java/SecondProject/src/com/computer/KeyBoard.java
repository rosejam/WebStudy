package com.computer;

public class KeyBoard extends Parts {
	String type;
	
	public KeyBoard(String type, String maker, int price) {
		super(maker, price); //부모생성자의 디폴트가없어서 자동으로 생성되지 않고 파라메터 2개를 꼭 받으므로 이 부분을 적어주어야함!!!!
		this.type = type;
	}

	public void keyType(){
		System.out.println("KeyBoard typing...");
	}
	
	public void info() {
		super.info();
		System.out.println("type:" + type);
	}	
}
