package com.app;

import java.util.List;

import com.dao.CustomerDAO;
import com.dao.ICustomer;
import com.domain.Customer;

//client program
public class CustomerTest {

	public static void main(String[] args) {
		//CustomerDAO dao = new CustomerDAO();
		ICustomer dao = new CustomerDAO(); //위와 차이점 : 인터페이스 내의 메소드만 호출 가능(DAO에서 추가한 메소드는 사용 불가, 내부적으로만 사용)
		List<Customer> list = dao.selectAll();
		for (Customer rec : list) {
			System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
		}
		System.out.println("----------------------------");
		
		Customer rec = dao.selectOne("729");
		System.out.println(rec.getNum() + "--" + rec.getName() + "--" + rec.getAddress());
	}

}
