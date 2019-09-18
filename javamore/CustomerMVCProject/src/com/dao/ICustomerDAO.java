package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface ICustomerDAO {
	//db작업을 하기 위해 필요한 Connection 객체 생성해서 리턴
	Connection getConnection();
	
	//마무리 작업 메소드
	void close(Statement stat, ResultSet rs, Connection con, PreparedStatement pstat);
	
	//모든데이터 검색
	ArrayList<Customer> selectAll();
	
	//번호 기준 검색
	Customer selectOne(String num);
	
	//주소 기준 검색
	ArrayList<Customer> findByAddress(String address);
	
	//새레코드 추가
	int insert(Customer c);
	
	//레코드 수정
	int update(String num, String address);
	
	//레코드 삭제
	int delete(String num);	
	
	

}












