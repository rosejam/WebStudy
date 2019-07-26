package com.computer;

public class Mouse extends Parts {
	boolean wireless;			
	
	public Mouse(String maker, boolean wireless, int price) {
		super(maker, price);
		this.wireless = wireless;
	}

	void leftClick(){
		System.out.println("Mouse_LeftClick");
	}
	
	void rightClick(){
		System.out.println("Mouse_RightClick");
	}
	
	void wheeling(){
		System.out.println("Mouse_wheeling");
		
	}

	public void info() {	
		super.info();
		System.out.println("wireless:" + wireless);			
	}
	
}







