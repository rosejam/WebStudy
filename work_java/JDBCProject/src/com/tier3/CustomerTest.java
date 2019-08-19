package com.tier3;

import java.util.ArrayList;

//client program
public class CustomerTest {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAO(); //1.driver 등록도 같이 됨
		Customer dongju = new Customer("010", "dongju", "seoul");
		ArrayList<Customer> list = dao.selectAll(); //이걸 받기 위해 list만들기
		
		System.out.println("select All>>>>>>>>>>>>>");
		for(Customer c:list) {
			System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
		}
		
		Customer c0 = dao.selectOne("121");
		System.out.println("select One>>>>>>>>>>>>>");
		System.out.println(c0.getNum()+"--"+c0.getName()+"--"+c0.getAddress());
		
		list = dao.findByAddress("london");
		System.out.println("Find by Address>>>>>>>>>>>>>");
		for(Customer c1:list) {
			System.out.println(c1.getNum()+"--"+c1.getName()+"--"+c1.getAddress());
		}
		System.out.println("insert>>>>>>>>>>>>>");
		int x = dao.insert(dongju);
		System.out.println(x);
		
		Customer c1 = dao.selectOne("010");
		System.out.println("select One>>>>>>>>>>>>>");
		System.out.println(c1.getNum()+"--"+c1.getName()+"--"+c1.getAddress());
		
		System.out.println("update>>>>>>>>>>>>>");
		x = dao.update("010", "la");
		System.out.println(x);
		
		Customer c2 = dao.selectOne("010");
		System.out.println("select One>>>>>>>>>>>>>");
		System.out.println(c2.getNum()+"--"+c2.getName()+"--"+c2.getAddress());
		
		System.out.println("delete>>>>>>>>>>>>>");
		x = dao.delete("010");
		System.out.println(x);
		
		list = dao.selectAll();
		System.out.println("select All>>>>>>>>>>>>>");
		for(Customer c:list) {
			System.out.println(c.getNum()+"--"+c.getName()+"--"+c.getAddress());
		}
		
	}
}
