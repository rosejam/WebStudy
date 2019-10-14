package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.domain.Customer;

public interface ICustomer {
	
	List<Customer> selectAll();	
	Customer selectOne(String num);	
	List<Customer> findByAddress(String address);	
	int insert(Customer c);
	int update(String num, String address);
	int delete(String num);	
	//getConnection과 close는 dao내에서만 사용
	ArrayList<Customer> search(String condition, String word);

}












