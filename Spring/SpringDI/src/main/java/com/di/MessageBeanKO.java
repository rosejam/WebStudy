package com.di;

public class MessageBeanKO implements MessageBean {
	private String num;
	private String name;
	Truck truck;
	
	//ii)Setter 주입
	public void setNum(String num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//i)생성자 주입
	public MessageBeanKO(Truck truck) {
		this.truck = truck;
	}
	
	@Override
	public void sayHello() {
		System.out.println("hello, "+ num);
		System.out.println("hello, "+ name);
		truck.run(); //그냥 돌리면 객체가 생성안됬으므로 null pointer Exception
		
	}
	
}
