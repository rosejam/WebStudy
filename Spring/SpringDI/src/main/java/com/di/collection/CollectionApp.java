package com.di.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");
		
		//getBean
		MyCollection c = context.getBean("col", MyCollection.class);
		//service method - 4 개
		c.arrayInfo();
		c.listInfo();
		c.setInfo();
		c.mapInfo();
		
	}

}
