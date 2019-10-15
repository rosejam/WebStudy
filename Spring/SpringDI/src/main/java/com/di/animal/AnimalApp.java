package com.di.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("animal.xml");
		
		//getBean
		Animal t = context.getBean("tiger", Animal.class);
		Animal l = context.getBean("lion", Animal.class);
		
		t.info();
		l.info();
		
	}

}
