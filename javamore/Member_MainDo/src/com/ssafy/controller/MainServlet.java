package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Member;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService=new MemberServiceImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		System.out.println("action:"+action);
		try {
			if(action != null) {
				if(action.endsWith("memberRegistForm.do")) {
					url = "/member/memberRegister.html";
				}else if(action.endsWith("memberRegist.do")) {
					url = memberRegist(request, response);
				}else if(action.endsWith("memberSearch.do")) {
					url = memberSearch(request, response);
				}else if(action.endsWith("memberUpdate.do")) {
					url = memberUpdate(request, response);
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
		}else if(url.startsWith("redirect")) { //리다이렉트
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else { //포워드
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private String memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Member member = new Member(id,pw,name,email,phone,address);
		memberService.update(member);
		return "redirect:main.do?action=memberSearch.do&id="+id;
	}
	private String memberSearch(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		request.setAttribute("member", memberService.search(id));
		return "member/memberSearch.jsp";
	}
	private String memberRegist(HttpServletRequest request, HttpServletResponse response) {
		//1. 요청 정보 추출
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Member member = new Member(id,pw,name,email,phone,address);
		memberService.add(member);
		
		/* insert 후 forward 해보기*/
		request.setAttribute("member", member);
		return "/member/memberSearch.jsp";
		//return "redirect:main.do?action=membersearch.do&id="+id;
	}
	
}











