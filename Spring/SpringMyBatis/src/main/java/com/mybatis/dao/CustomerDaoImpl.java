package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mybatis.vo.Customer;

//dao객체(crud)
@Component("cdao")
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	SqlSession session; //SqlSessionTemplate빈(세션 객체)이 주입된다.
	
	@Override
	public List<Customer> selectAll() {
		return session.selectList("customer.selectAll"); //"네임스페이스.쿼리id" <- Mapperfile에 있음
	}

	@Override
	public Customer selectOne(String num) {
		return session.selectOne("customer.selectOne", num);
	}

	@Override
	public int insert(Customer c) {
		int x = session.insert("customer.insert", c);
		return x;
	}

	@Override
	public int delete(String num) {
		int x = session.delete("customer.delete", num);
		return x;
	}

	@Override
	public List<Customer> findByAddress(String address) {
		return session.selectList("customer.findAddress", address);
	}

	@Override
	public void update(Customer c) {
		session.update("customer.update", c);
	}

}
