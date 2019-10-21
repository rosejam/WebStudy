package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybatis.dao.CustomerDao;
import com.mybatis.vo.Customer;

//클라이언트(CustomerApp.java)가 사용하는 객체 -> 이 객체를 getBean해가서 이 안의 메소드를 활용
@Component("cus")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDao dao; //type기준으로 주입 (CustomerDaoImpl은 CustomerDaoImpl타입이자 부모인 CustomerDao타입이기도 함!!!!)
					 //	-> 실제로는 CustomerDaoImpl을 주입한다!
					 //(인터페이스이므로 다른 자식도 주입할 수 있다!!)
	
	@Override
	public List<Customer> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Customer selectOne(String num) {
		return dao.selectOne(num);
	}

	@Override
	public void insert(Customer c) {
		dao.insert(c);
	}
	
	@Override
	public void delete(String num) {
		dao.delete(num);
	}

	@Override
	public List<Customer> findByAddress(String address) {
		return dao.findByAddress(address);
	}

	@Override
	public void update(Customer c) {
		dao.update(c);
	}
	
	@Override 
	public void insert2(Customer c) throws Exception {
/*		try {
			dao.insert(c);
			dao.insert(c); //프라이머리키 중복으로 에러 발생
			//트랜잭션 처리하지 않을 경우 첫번째줄만 실행되고 캐치로 넘어가므로 insert가 됨!!!
		}catch(Exception q) {
			
		}*/
		dao.insert(c);
		dao.insert(c);
	}
	
}
