package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); //해야 하는 일이 같은 경우
	}//HTTP Status 405 – Method Not Allowed(서블릿과 html의 do/post방식이 안맞을 때 발생)
	//클라이언트가 post방식으로 요청을 보내오면 받아서 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter로 전송되어 온 한글 처리(client -> server)
		//클라이언트가 서버로 보낼때="요청 들어올 때(request)" 아이디 등의 한글이 안깨지도록 하므로, request.getParameter이전에 수행되어야 한다!
		request.setCharacterEncoding("euc-kr");
		
		//server -> client에서 한글이 안깨지도록
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		//클라이언트가 보내온 값 받기~
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String code = request.getParameter("code");
		
		out.println("<html><body>");
		out.println("<h1>" + id + "님!... 환영합니다.<br>");
		out.println("패스워드는 " + pass + "이고 ");
		out.println("코드는 " + code + "입니다.</h1>");
		out.println("<a href=form/login.html>back</a>"); //자바가 아닌애들은 링크 걸 때 경로도 적어주어야한다.
		out.println("</body></html>");
	}
	
}
