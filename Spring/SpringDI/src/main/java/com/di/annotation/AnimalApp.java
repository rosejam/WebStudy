package com.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation.xml");
		
		//LondonZoo에 주입을 하고
		Zoo z = context.getBean("london", Zoo.class);
		
		z.info();
	}

}
