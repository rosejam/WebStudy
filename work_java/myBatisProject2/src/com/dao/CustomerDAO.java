package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MyBatisUtil;
import com.domain.Customer;

public class CustomerDAO implements ICustomer {

	@Override
	public List<Customer> selectAll() {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Customer.selectAll");
	}

	@Override
	public Customer selectOne(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectOne("Customer.selectOne", num);
	}

/*	@Override
	public List<Customer> findByAddress(String address) {
		SqlSession session = MyBatisUtil.getSqlSession();
		return session.selectList("Customer.findAddress",address);
	}*/

	@Override
	public int insert(Customer c) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int x = session.insert("Customer.insert", c);
		session.commit();
		return x;
	}

	@Override
	public int update(String num, String address) {
		SqlSession session = MyBatisUtil.getSqlSession();
		HashMap<String,String> map = new HashMap<>();
		map.put("num", num);
		map.put("address", address);
		int x = session.update("Customer.update2", map);
		session.commit();
		return x;
	}

	@Override
	public int delete(String num) {
		SqlSession session = MyBatisUtil.getSqlSession();
		int x = session.delete("Customer.delete", num);
		session.commit();
		return x;
	}
	
	//다이나믹 쿼리 용으로 맵에 키 밸류를 넣어서 준다.
	@Override
	public List<Customer> searchAll(String condition, String word) {
		SqlSession session = MyBatisUtil.getSqlSession();
		HashMap<String, String> map = new HashMap<String, String>();
		
        map.put("key", condition);//검색조건
        map.put("word", word);//검색어	
        return session.selectList("searchAll", map);
	}

}
