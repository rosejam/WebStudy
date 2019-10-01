package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet("*.do") //모든 것.do
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService=new MemberServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		System.out.println(action);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			if(action !=null) {
				if(action.endsWith("cookietest.do")) {
					url = cookietest(request, response);
				}else if(action.endsWith("cookielogin.do")) {
					url = cookielogin(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private String cookielogin(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String idsave = request.getParameter("idsave");
		
		Cookie cookie = new Cookie("idsave", id);
		if(idsave != null) { //체크박스를 선택한 경우 => id를 쿠키에 저장
			cookie.setMaxAge(2111111111);
		}else { //체크박스를 선택하지 않음 => 기존에 발행한 쿠키가 있다면 삭제
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		return "redirect:CookieLogin.jsp";
	}
	private String cookietest(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("cookiename");
		String value = request.getParameter("cookievalue");
		
		Cookie cookie = new Cookie(name, value);
		/* 음수(-1) 	: 메모리에만 저장. 브라우저가 종료되면 사라짐. 
		 * 0 		: 기존에 발행한 쿠키 삭제(이름이 같은 것 삭제)
		 * 양수	 	: 지정한 시간만큼 유지
		 * */
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "/CookieTest.jsp";
	}
}











