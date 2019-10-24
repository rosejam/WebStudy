package com.ssafy;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerApp {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("spring/application-config.xml");
		
		CustomerService service = 
				context.getBean("cus", CustomerService.class);
		
		
		List<Customer> list = service.selectAll();
		for(Customer c : list){
			System.out.println(
				c.getNum() + "--" + c.getName() + "--" + c.getAddress());
		}
		
		Customer c = service.selectOne("1111");
		if(c != null)
			System.out.println(
				c.getNum() + "--" + c.getName() + "--" + c.getAddress());
		else
			System.out.println("no data");
	}

}






