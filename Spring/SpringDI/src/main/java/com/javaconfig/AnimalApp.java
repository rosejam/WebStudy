package com.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//AnnotationConfigApplicationContext : 같은 패키지에서 @Configuration 자바 클래스(xml대신) 를 읽어서 컨테이너를 생성한다!

public class AnimalApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class); //(Configuration클래스이름.class)를 넣어준다!!
		Animal tiger = context.getBean("getTiger", Animal.class);
		tiger.info();
		
		Animal lion = context.getBean("getLion", Animal.class);
		lion.info();
		
	}

}
