package com.di.animal.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZooApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("animalcollection.xml");
		
		//LondonZoo, ParisZoo getBean해서 info() 호출
		Zoo l = context.getBean("london", LondonZoo.class);
		Zoo p = context.getBean("paris", ParisZoo.class);
		l.info();
		p.info();
		
	}

}





