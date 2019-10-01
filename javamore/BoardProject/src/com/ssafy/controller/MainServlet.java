package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.BoardService;
import com.ssafy.model.service.BoardServiceImpl;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet({"*.do","*.log"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
	private MemberService memberService=new MemberServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getServletPath(); //인코딩보다 나중에
		try {
			if(action!=null) {
				if(action.endsWith("main.do") || action.endsWith("boardlist.do")) {
					System.out.println("board...");
					url = boardlist(request,response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}

		if(url.startsWith("{") ||url.startsWith("[") ) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().append(url);
		}else if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private String boardlist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}
	
}











