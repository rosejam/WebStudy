package com.sample3;

public class MessageBeanEN implements MessageBean {
	
	public MessageBeanEN() {
		System.out.println("MessageBeanEN 생성자");
	}
	@Override
	public void sayHello() {
		System.out.println("hello, spring.....");
		
	}

}
