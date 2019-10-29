package com.javaconfig;

public class Tiger implements Animal {
	int age;
	String name;
		
	public void setName(String name){
		this.name = name;
	}
	
	public Tiger(int age){
		this.age = age;
	}
	
	@Override
	public void info() {
		System.out.println("age:" + age);
		System.out.println("name:" + name);
		
	}

}
