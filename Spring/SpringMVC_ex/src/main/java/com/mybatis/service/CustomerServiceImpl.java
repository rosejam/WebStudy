package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.CustomerDao;
import com.mybatis.vo.Customer;

//클라이언트(CustomerApp.java)가 getBean해서 사용하는 객체. 서비스 객체
//CustomerApp.java가 getBean()해 간 후에 메소드 호출해서 사용함
//@Component("cus")
@Service("cus")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao dao;//type 기준으로 주입. CustomerDaoImpl이 실제로 주입됨		
	
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
		
			dao.insert(c);
			dao.insert(c);
		
		
	}

}







