package com.di;

public class MessageBeanEN implements MessageBean {
	private String num;
	private String name;
	Truck truck;
	
	//i)생성자 주입
	public MessageBeanEN(String num, String name) {
		this.num = num;
		this.name = name;
	}
	
	//ii)setter 주입
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	
	@Override
	public void sayHello() {
		System.out.println("hello, "+ num);
		System.out.println("hello, "+ name);
		truck.run();
	}

}
