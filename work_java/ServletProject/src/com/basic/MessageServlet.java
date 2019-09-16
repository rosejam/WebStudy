package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter(); //이 두줄은 필수
		
		System.out.println("MessageServlet");
		
		out.println("<h1>Welcome, Message Servlet</h1>");
		out.println("<a href=Hello>go to helloServlet</a>"); //href 링크에 url mapping값을 넣는다~
	}
}
