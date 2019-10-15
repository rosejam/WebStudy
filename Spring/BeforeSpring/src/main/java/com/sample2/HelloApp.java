package com.sample2;

public class HelloApp { //HelloApp은 MessageBean들에 의존성이 있다!

	public static void main(String[] args) {
		MessageBean bean = new MessageBeanEN();
		bean.sayHello();
		
	}

}
