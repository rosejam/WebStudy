package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Survey")
public class Survey extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		String dept = request.getParameter("dept");
		String employee = request.getParameter("employee");
		String comment = request.getParameter("comment");
		//Checkbox의 값 받을 때
		String[] ide = request.getParameterValues("ide"); //name이 ide인 것들의 value들 - Parameter는 무조건 다 스트링
		
		out.println("<html><body>");
		out.println("<h1>dept="+dept+"<br>employee="+employee+"<br>comment="+comment);
		out.println("<br>");
		for(String v:ide) {
			out.println("<br>"+v);
		}
		out.println("</h1></body></html>");
	}
	
}
