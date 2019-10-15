package com.phone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample3.MessageBean;

public class PhoneApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("phone.xml");
		Phone bean = context.getBean("p1", Phone.class);
		Phone bean2 = context.getBean("p2", Phone.class);
		bean.info();
		bean2.info();
	}

}
