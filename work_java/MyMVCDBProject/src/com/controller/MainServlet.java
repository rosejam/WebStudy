package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDAO;
import com.domain.Customer;

//http://localhost:8080/MyMVCProject/main.do
@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("EUC-KR");		
		String action = req.getParameter("action");
		
		CustomerDAO dao = new CustomerDAO(); //1. 원래는 한번만 생성해야 함
		
		if(action == null){	//처음에는 parameter가 없으므로 여기로 
			//db
			List<Customer> list = dao.selectAll(); // dao에 DB 작업 지시
			req.setAttribute("list", list); //2. req에 저장
			RequestDispatcher dis = req.getRequestDispatcher("view/index.jsp"); //초기화면이 뜨도록
			dis.forward(req, res); //3. jsp에 forward
			return;
		
		}else if(action.equals("detail")) {
			String num = req.getParameter("num");
			Customer c = dao.selectOne(num);
			req.setAttribute("c", c); //req에 넣어 저장
			
			//req에 결과 저장 후 jsp로 forward 방식으로 jsp로 전환
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/read.jsp"); //jsp의 위치경로
			try {
				dispatcher.forward(req, res);//jsp로 forward 시킴
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("insertForm")) {
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/insertForm.jsp");
			try {
				//res.sendRedirect("/customer/insertForm.jsp");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("insertProcess")) {
			//num, name, address받기
			//db에 insert
			String num = req.getParameter("num"); //이름을 num으로 저장하였음
			String name = req.getParameter("name");
			String address  = req.getParameter("address");
			Customer c = new Customer(num, name, address);
			dao.insert(c);
			
			req.setAttribute("c", c);
			
			//forward 방식으로 jsp로 전환
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/insertSuccess.jsp");		
			try {
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("delete")) {
			String num = req.getParameter("num");
			dao.delete(num);
			//list(req,res);
			res.sendRedirect("main.do");
			
		}else if(action.equals("search")) {
/*			String address = req.getParameter("address");
			
			ArrayList<Customer> list = dao.findByAddress(address);
			//System.out.println(list);
			
			try {
				if(list.size() == 0) { //list자체가 null은 아니므로 size로 비교해야함~
					res.sendRedirect("/view/search.jsp");
				}else {
					req.setAttribute("list", list);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/view/index.jsp");
					dispatcher.forward(req, res);//jsp로 forward 시킴
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			String condition = req.getParameter("condition"); //번호 이름 주소
			String word = req.getParameter("word");
			
			ArrayList<Customer> list = dao.search(condition, word);
			//System.out.println(list);
			
			try {
				if(list.size() == 0) { //list자체가 null은 아니므로 size로 비교해야함~
					res.sendRedirect("/view/search.jsp");
				}else {
					req.setAttribute("list", list);
					RequestDispatcher dispatcher = req.getRequestDispatcher("/view/index.jsp");
					dispatcher.forward(req, res);//jsp로 forward 시킴
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("updateForm")) {
			String num = req.getParameter("num");
			req.setAttribute("num", num);
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/updateForm.jsp");
			
			try {
				//res.sendRedirect("/customer/insertForm.jsp");
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("updateProcess")) {
			//num, name, address받기
			//db에 insert
			String num = req.getParameter("num");
			String address  = req.getParameter("address");
			dao.update(num,address);
			
			Customer c = dao.selectOne(num);
			req.setAttribute("c", c);
			
			//forward 방식으로 jsp로 전환
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/insertSuccess.jsp");		
			try {
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}