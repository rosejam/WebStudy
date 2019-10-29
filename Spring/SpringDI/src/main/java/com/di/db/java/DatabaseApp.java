package com.di.db.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DatabaseApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DBJavaConfig.class);
		DataService mysql = context.getBean("getMySQL", DataService.class);
		mysql.info();
		
		DataService oracle = context.getBean("getOracle", DataService.class);
		oracle.info();
		
	}
}
