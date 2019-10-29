package com.dao;

import java.util.List;

import com.domain.Customer;

public interface ICustomer {
	
	
	List<Customer> selectAll();	
	Customer selectOne(String num);	
	//List<Customer> findByAddress(String address);	
	int insert(Customer c);
	int update(String num, String address);
	int delete(String num);	
	
	List<Customer> searchAll(String condition, String word);

}












