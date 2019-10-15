package com.di.animal.collection;

public class Lion implements Animal {
	int age;	
	String name;
	
	public Lion(int age) {
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
