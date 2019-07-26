package com.computer;

public class Monitor extends Parts {
	double size;
	
	public Monitor(double size, String maker, int price) {
		super(maker, price);
		this.size = size;
	}
	public void powerOn(){
		System.out.println("Monitor_PowerOn");	
		
	}
	public void powerOff(){
		System.out.println("Monitor_PowerOff");	
		
	}

	
	public void info() {
		super.info();
		System.out.println("size:" + size);
	}
	
}


