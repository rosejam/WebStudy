package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BoardDAO;
import com.dao.IBoard;
import com.vo.Board;

public class BoardController {
	IBoard bean;
	
	public BoardController() { 
		bean = new BoardDAO();
	}
	
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Board> list = bean.selectAll();
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
		try {
			dispatcher.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void detail(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		bean.countUp(num); //조회수 올리는 용도 추가!
		Board b = bean.selectOne(num);
		req.setAttribute("b", b);
		
		//view로 넘어가기(forward방식. 동일한 req를 사용)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/read.jsp");
		
		try {
			dispatcher.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void detail2(HttpServletRequest req, HttpServletResponse res) { //조회수를 늘리지 않고 엿보기
		String num = req.getParameter("num");
		Board b = bean.selectOne(num);
		req.setAttribute("b", b);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/read2.jsp");
		
		try {
			dispatcher.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertForm(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/view/insertForm.jsp");
		try {
			//res.sendRedirect("/customer/insertForm.jsp");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertSuccess(HttpServletRequest req, HttpServletResponse res) {
		String title = req.getParameter("title"); //이름을 num으로 저장하였음
		String name = req.getParameter("name");
		String pass  = req.getParameter("pass");
		String content  = req.getParameter("content");
		Board b = new Board(null,pass,name,null,title,content,null);
		bean.insert(b);
		
		req.setAttribute("b", b);
		
		//forward 방식으로 jsp로 전환
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/view/insertSuccess.jsp");		
		try {
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search(HttpServletRequest req, HttpServletResponse res) {
		String condition = req.getParameter("condition"); //title or name
		String word = req.getParameter("word");
		
		ArrayList<Board> list = bean.search(condition, word);
		//System.out.println(list);
		
		try {
			if(list.size() == 0) { //list자체가 null은 아니므로 size로 비교해야함~
				res.sendRedirect("/board/view/search.jsp");
			}else {
				req.setAttribute("list", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
				dispatcher.forward(req, res);//jsp로 forward 시킴
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		bean.delete(num);
		list(req,res);
	}
	
}
