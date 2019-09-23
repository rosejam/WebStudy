package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Customer;
import com.dao.CustomerDAO;
import com.dao.ICustomerDAO;

//Front Controller에서 넘어온 요청을 Model에게 넘겨서 작업 지시
//Model이 작업 한 결과를 받아서 저장한 후에 jsp로 넘어 감(forward).pojo
public class CustomerController {
	ICustomerDAO bean;
	
	public CustomerController(){ //생성자에서 DAO생성
		bean = new CustomerDAO();
	}
	
	public void list(HttpServletRequest req, HttpServletResponse res) {
		//세션에 현재 위치 저장시켜놓고 로그인했을 경우 돌아오기
		HttpSession session = req.getSession(); //session을 얻어오기
		session.setAttribute("cpage", req.getRequestURI());
		System.out.println(req.getRequestURI()); // /customer/list.cus
		
		ArrayList<Customer> list = bean.selectAll();
		req.setAttribute("list", list);//jsp에서 접근해서 사용하도록 저장
		
		//forward 방식으로 jsp로 전환
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/list.jsp"); //jsp의 위치경로
		try {
			dispatcher.forward(req, res);//jsp로 forward 시킴
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//고객 정보 한개 처리
	public void read(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		Customer c = bean.selectOne(num);
		req.setAttribute("c", c); //req에 넣어 저장
		
		//forward 방식으로 jsp로 전환
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/read.jsp"); //jsp의 위치경로
		try {
			dispatcher.forward(req, res);//jsp로 forward 시킴
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertForm(HttpServletRequest req, HttpServletResponse res) {
		//session을 체크해서 로그인 정보가 있나 확인하고 상황에 맞는 화면으로 forward
		HttpSession session = req.getSession(); //session을 얻어오기(Jsp와 다르게 이 과정이 필요) 
												//이전에 만들어논 세션이 있으면 return해주고 없으면 새로 하나 만들어서 return해줌
		String id = (String)session.getAttribute("id");
		session.setAttribute("cpage", req.getRequestURI());//세션에 현재 위치 저장시켜놓고 로그인했을 경우 돌아오기
		
		String url ="";
		
		if(id != null) { //로그인 한 경우
			//입력하는 화면이 뜨게 한다(db에 넣는 작업 이전)
			url = "/customer/insertForm.jsp";
		}else { //로그인 안한 경우
			url = "/customer/login.jsp";
		}
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher(url);
		try {
			//res.sendRedirect("/customer/insertForm.jsp");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(HttpServletRequest req, HttpServletResponse res) {
		//num, name, address받기
		//db에 insert
		String num = req.getParameter("num"); //이름을 num으로 저장하였음
		String name = req.getParameter("name");
		String address  = req.getParameter("address");
		Customer c = new Customer(num, name, address);
		bean.insert(c);
		
		req.setAttribute("c", c);
		
		//forward 방식으로 jsp로 전환
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/insertSuccess.jsp");		
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		bean.delete(num);
		list(req,res);
	}

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {//로그인 처리 요청
		//클라이언트가 입력한 id를 받아와서 세션에 저장시킴
		String id = req.getParameter("id"); //db에서 체크하는 과정 생략
		HttpSession session = req.getSession(); //session을 얻어오기
		session.setAttribute("id", id); //session에 저장
		String cpage = (String)session.getAttribute("cpage"); // list.cus나 insert.cus 중에 원래 있던 곳으로 돌아간다.
		
		try {
			res.sendRedirect(cpage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {//로그인 화면 요청
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/customer/login.jsp");		
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {//로그아웃 요청
		HttpSession session = req.getSession(); //session을 얻어오기
		session.setAttribute("id", null); //session에서 지우기
		
		try {
			res.sendRedirect("list.cus"); //초기화면으로
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
