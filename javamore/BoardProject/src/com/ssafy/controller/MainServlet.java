package com.ssafy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.Board;
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
		String action = request.getServletPath();
		System.out.println("action........"+action);
		try {
			if(action!=null) {
				if(action.endsWith("main.do")||action.endsWith("listBoard.do")) {
					url = boardlist(request, response);
				}else if(action.endsWith("searchBoard.do")) {
					url = searchBoard(request, response);
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
	private String searchBoard(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		Board board = boardService.search(no);
		request.setAttribute("board", board);
		
		HttpSession session = request.getSession();
		ArrayList<Board> seens = (ArrayList<Board>) session.getAttribute("seens");
		if(seens == null) {
			seens = new ArrayList<>(3);
			session.setAttribute("seens", seens);
			seens.add(board);
		}else {
			boolean isFind = false;
			for (Board seen : seens) {
				if(seen.getNo() == board.getNo()) {
					isFind = true;
					break;
				}
			}
			if(!isFind) {
				if(seens.size()==3) {
					seens.remove(2);
				}
				seens.add(0, board);
			}
		}
		return "/board/searchBoard.jsp";
	}
	private String boardlist(HttpServletRequest request, HttpServletResponse response) {
		String key  = request.getParameter("key");
		String word  = request.getParameter("word");
		String pageNo  = request.getParameter("pageNo");
		
		PageBean bean = new PageBean(key, word, pageNo);
		request.setAttribute("bean", bean);
		request.setAttribute("list", boardService.searchAll(bean));
		return "/board/listBoard.jsp";
	}
}











