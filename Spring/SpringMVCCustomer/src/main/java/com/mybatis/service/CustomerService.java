package com.mybatis.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mybatis.vo.Customer;

//client(CustomerApp.java)를 위한 인터페이스
public interface CustomerService {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public void insert(Customer c);
	public void delete(String num);
	public List<Customer> findByAddress(String address);
	public void update(Customer c);
	
	@Transactional
	public void insert2(Customer c) throws Exception;
	//public void txTest(String num);
	public List<Customer> jointest();//
	
}





