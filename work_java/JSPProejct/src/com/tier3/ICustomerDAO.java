package com.tier3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public interface ICustomerDAO { //메서드 껍데기들
	//db작업을 하기 위해 필요한 Connection 객체 생성해서 리턴
	//다음 과정들 전에 먼저 필요한 과정
	Connection getConnection();
	
	//다음 과정들 후에 필요한 마무리 작업
	void close(Statement stat, ResultSet rs, Connection con, PreparedStatement pstat);
	
	//모든 데이터 검색
	ArrayList<Customer> selectAll();
	
	//번호 기준 검색 - VO 한개 리턴
	Customer selectOne(String num);
	
	//주소 기준 검색
	ArrayList<Customer> findByAddress(String address);
	
	//새 레코드 추가
	//int insert(String num, String name, String address)
	int insert(Customer c);
	
	//레코드 주소 수정
	int update(String num, String address);
	
	//레코드 삭제
	int delete(String num);

	
}
