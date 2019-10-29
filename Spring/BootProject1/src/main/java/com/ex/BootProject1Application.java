package com.ex;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//ApplicationContext : 컨테이너

//@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration 등
//		@Configuration : spring 설정 정보를 가지고 있는 자바 클래스. xml 문서를 대신함!!
//		@ComponentScan : 뒤에 패키지를 지정하면 그 패키지를 뒤짐. 지정안할 경우 "이 클래스가 있는 폴더 기준으로 아래"를 모두 스캔
//		@EnableAutoConfiguration : 자동설정을 지정해줌. Factory 등을 따로 생성하지 않아도 됨

@SpringBootApplication //"부트 스트랩 클래스" (시작 클래스 : 어플리케이션 실행에 필요한 객체 생성이나 설정 작업 등을 자동으로 수행해줌)
public class BootProject1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProject1Application.class, args); //런메소드에 부트스트랩클래스를 넣어주어 컨테이너를 만들기
		/*
		String[] names = ctx.getBeanDefinitionNames();
		Arrays.parallelSort(names);
		for(String name : names) {
			System.out.println(name); //ctx컨테이너 객체의 bean의 이름을 배열로 받아서 출력(빈이 엄청많음)
		}
		*/
	}

}
