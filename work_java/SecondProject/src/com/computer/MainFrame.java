package com.computer;

public class MainFrame extends Parts {
	String cpu;	
	
	public MainFrame(String cpu, String maker, int price) {
		super(maker, price);
		this.cpu = cpu;
	}

	public void powerOn(){
		System.out.println("MainFrame_PowerOn");		
	}
	
	public void powerOff(){
		System.out.println("MainFrame_PowerOff");		
	}

	
	public void info() {
		super.info();
		System.out.println("cpu:" + cpu);
	}
	
}








