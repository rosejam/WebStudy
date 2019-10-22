package com.mybatis.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.service.CustomerService;
import com.mybatis.vo.Customer;

public class CustomerApp {

	public static void main(String[] args) throws Exception {
		//Container 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("config/mybatis-db.xml");
		
		CustomerService service = context.getBean("cus", CustomerService.class); //interface타입에 받기
		
		//service.delete("99");
		Customer cc = new Customer("99","bambie","london");
		try {
			service.insert2(cc); //transaction처리된 메서드를 try~catch로 받는다.
		}catch(Exception e) {
			//System.out.println("insert2를 할 수 없다~ 롤백됨~");
		}
		
		List<Customer> list = service.selectAll();
		for(Customer c: list) {
			System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
		}
/*		//selectOne
		Customer cc = service.selectOne("343");
		System.out.println(cc.getNum() + "--" + cc.getName() + "--" + cc.getAddress());
		//insert
		service.insert(new Customer("342","서정진","서울"));
		//delete
		service.delete("311");
		//update
		service.update(new Customer("343",null,"서울"));
		//findByAddress
		List<Customer> list2 = service.findByAddress("서울");
		for(Customer c: list2) {
			System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
		}*/
		
	}
	
}
