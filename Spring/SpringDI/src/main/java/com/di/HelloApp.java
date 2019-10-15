package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//container 기능 : application에서 필요한 "객체를 생성~소멸까지 관리"해 주는 객체
//ApplicationContext : 스프링에서 제공해주는 "컨테이너 클래스". 자식 클래스 중의 하나를 생성해서 사용
//ClassPathXmlApplicationContext : classpath위치(= src/main/resources)의 "xml문서를 읽어서 객체 생성"해서 대기 시킴
//FileSystemXmlApplicationContext : 주어진 경로의 xml문서를 읽어서 ~
public class HelloApp { //HelloApp의 MessageBean에 대한 의존성이 낮아짐

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("di.xml"); //컨테이너 생성
		MessageBean bean = context.getBean("bean1", MessageBean.class); //원하는 객체 요청
		MessageBean bean2 = context.getBean("bean2", MessageBean.class);
		
		bean.sayHello(); //business method
		System.out.println("--------------------------------------------------------");
		bean2.sayHello();
		
	}

}
