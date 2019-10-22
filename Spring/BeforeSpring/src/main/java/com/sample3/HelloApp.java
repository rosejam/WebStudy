package com.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//container 기능 : application에서 필요한 "객체를 생성~소멸까지 관리 및 공급"해 주는 객체
//"ApplicationContext" : 스프링에서 제공해주는 "컨테이너 클래스". 자식 클래스 중의 하나를 생성해서 사용
//ClassPathXmlApplicationContext : classpath위치(= src/main/resources)의 "xml문서를 읽어서 객체 생성"해서 대기 시킴
//FileSystemXmlApplicationContext : 주어진 경로의 xml문서를 읽어서 ~
public class HelloApp { //HelloApp의 MessageBean에 대한 의존성이 낮아짐

	public static void main(String[] args) {
//		MessageBean bean = new MessageBeanEN();
//		bean.sayHello();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml"); //container 생성 //xml문서를 읽어서 "객체 생성"해서 대기 시킴
		//ApplicationContext context = new FileSystemXmlApplicationContext("c:\\ssafy\\context.xml");
		
		//공통의 부모인 인터페이스 타입(MessageBean)으로 받는다!!
		//원하는 객체가 바뀔 경우 xml만 수정하면 된다.
		MessageBean bean = context.getBean("bean1", MessageBean.class); //원하는 객체 요청 //(생성해놓은 id가 bean1인 "객체를 리턴", MessageBean타입으로 변환)
		MessageBean bean2 = context.getBean("bean1", MessageBean.class);
		//MessageBean bean = (MessageBean)context.getBean("bean1"); //타입 변환을 앞에 적어주었다.
		
		//scope="singleton"(디폴트) : 객체는 1개만 만들어서 다시 리턴했기 때문에 동일한 객체
		//scope="prototype" : getBean()했을 때 객체를 새로 생성해서 리턴
		System.out.println(bean == bean2); //
		
		bean.sayHello(); //.sayHello() 비즈니스(핵심) 메소드. 이 메서드를 쓰기위해 위의 과정을 실행
		bean2.sayHello();
	}

}
