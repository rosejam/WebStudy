package com.di.animal.collection;

public class Tiger implements Animal {
	int age;
	String name;
		
	public Tiger(int age){
		this.age = age;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Override
	public void info() {
		System.out.println("age:" + age);
		System.out.println("name:" + name);
		
	}

}
