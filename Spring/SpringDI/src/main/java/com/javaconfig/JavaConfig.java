package com.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : spring 설정 정보를 가지고 있는 클래스. xml 문서를 대신함
@Configuration
public class JavaConfig {
	
	//@Bean : 리턴 타입의 객체가 생성됨. <bean>태그와 동일
	//메소드 이름이 생성되는 빈의 id가 됨
	@Bean
	public Tiger getTiger() {
		Tiger t = new Tiger(1);
		t.setName("king");
		return t;
	}
	
	@Bean
	public Lion getLion() {
		Lion l = new Lion(3);
		l.setName("queen");
		return l;
	}

}
