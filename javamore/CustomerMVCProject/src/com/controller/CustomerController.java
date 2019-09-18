package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Customer;
import com.dao.CustomerDAO;
import com.dao.ICustomerDAO;

//Front Controller에서 넘어온 요청을 Model에게 넘겨서 작업 지시
//Model이 작업 한 결과를 받아서 저장한 후에 jsp로 넘어 감(forward).pojo
public class CustomerController {
	ICustomerDAO bean;
	
	public CustomerController(){
		bean = new CustomerDAO();
	}
	
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Customer> list = bean.selectAll();
		req.setAttribute("list", list);//jsp에서 접근해서 사용하도록 저장
		
		//forward 방식으로 jsp로 전환
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/list.jsp");		
		try {
			dispatcher.forward(req, res);//jsp로 forward 시킴
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	//고객 정보 한개 처리
	public void read(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num"); //111,121
		Customer c = bean.selectOne(num);
		req.setAttribute("c", c);
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/read.jsp");		
		try {
			dispatcher.forward(req, res);//jsp로 forward 시킴
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void insertForm(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/insertForm.jsp");		
		try {
			dispatcher.forward(req, res);//jsp로 forward 시킴
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void insert(HttpServletRequest req, HttpServletResponse res) {
		//num,name,address 받기
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		//db insert
		Customer c = new Customer(num, name, address);
		bean.insert(c);
		req.setAttribute("c", c);
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/insertSuccess.jsp");		
		try {
			dispatcher.forward(req, res);//jsp로 forward 시킴
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");

		bean.delete(num);

		list(req, res);
		
	}

	

}
