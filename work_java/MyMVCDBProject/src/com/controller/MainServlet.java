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
import javax.servlet.http.HttpSession;

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
		
		req.setCharacterEncoding("EUC-KR"); //한글 나오도록 맞춰줌
		String action = req.getParameter("action");
		
		CustomerDAO dao = new CustomerDAO(); //1. 원래는 한번만 생성해야 함
		
		if(action == null || action.length() == 0){	//처음에는 parameter가 없으므로 여기로 
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
					req.getRequestDispatcher("/view/detail.jsp"); //jsp의 위치경로
			dispatcher.forward(req, res);//jsp로 forward 시킴
			
		}else if(action.equals("insertForm")) {
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/insertForm.jsp");
			dispatcher.forward(req, res);
			
		}else if(action.equals("insertProcess")) {
			//num, name, address받기
			//db에 insert
			String num = req.getParameter("num"); //이름을 num으로 저장하였음
			String name = req.getParameter("name");
			String address  = req.getParameter("address");
			
/*			Customer c = new Customer(num, name, address);
			dao.insert(c);
			req.setAttribute("c", c);
			
			try {
				dispatcher.forward(req, res);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			//예시
			RequestDispatcher dispatcher;
			
			if(dao.insert(new Customer(num, name, address)) >=1) {
				Customer c = dao.selectOne(num);
				req.setAttribute("c", c);
				//forward 방식으로 jsp로 전환
				dispatcher = 
						req.getRequestDispatcher("/view/insertSuccess.jsp");
			}
			else {
				dispatcher = 
						req.getRequestDispatcher("/view/insertForm.jsp");
			}
			
			dispatcher.forward(req, res);
			
		}else if(action.equals("delete")) {
			String num = req.getParameter("num");
			dao.delete(num);
			//list(req,res);
			res.sendRedirect("main.do"); //초기화면으로 그냥 가기!!!
			
		}else if(action.equals("search")) {
			String address = req.getParameter("word");
			ArrayList<Customer> list = dao.findByAddress(address);
			//System.out.println(list);
			
			if(list.size() == 0) { //list자체가 null은 아니므로 size로 비교해야함~
				res.sendRedirect("/view/search.jsp");
			}else {
				req.setAttribute("list", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/index.jsp");
				dispatcher.forward(req, res);//jsp로 forward 시킴
			}
			
/*			String condition = req.getParameter("condition"); //번호 이름 주소
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
			}*/
			
		}else if(action.equals("updateForm")) {
			/*String num = req.getParameter("num");
			req.setAttribute("num", num);
			
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/updateForm.jsp");*/
			
			String num = req.getParameter("num"); //위와 같이 num만 jsp로 hidden 하거나 readonly로 보내도 된다!!!
			Customer c = dao.selectOne(num);
			req.setAttribute("c", c);
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/updateForm.jsp"); //수정이 가능한 디테일
			
			dispatcher.forward(req, res);
			
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
			dispatcher.forward(req, res);
			
		}else if(action.equals("loginForm")) { //login 화면
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("/view/login.jsp");
			dispatcher.forward(req, res);
			
		}else if(action.equals("loginProcess")) { //"login 처리 : session에 로그인 정보 저장"
			HttpSession session = req.getSession(); //세션 얻어내기
			String id = req.getParameter("id");
			session.setAttribute("id", id); //세션에 id저장
			
			res.sendRedirect("main.do"); //초기화면으로 그냥 가기!!!
			
		}else if(action.equals("logout")) { //session에 저장된 로그인 정보 없애기
			HttpSession session = req.getSession(); //세션 얻어내기
			session.setAttribute("id", null);
			
			//res.sendRedirect("main.do");
			
		}
		
	}
	
}