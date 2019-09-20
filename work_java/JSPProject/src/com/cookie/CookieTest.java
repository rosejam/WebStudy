package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws IOException, ServletException {
		
		response.setContentType("text/html;charset=KSC5601");
		PrintWriter out = response.getWriter();		

		//Ŭ���̾�Ʈ�κ��� ������ �����ߴ� ��� ��Ű�� ��
		Cookie[] cookies = request.getCookies();

		if(cookies == null || cookies.length == 0) { //cookie�� ������
			
			return;

		}else{ //cookie�� �ϳ��� ������
			
			for(int i=0; i < cookies.length; i++) {			
				String cookieName = cookies[i].getName();				
				String cookieValue = cookies[i].getValue();
				
				out.println(cookieName+":"+cookieValue +"<BR>");
	   }	
		
			out.println("<html><body><center><h2>��Ű �׽�Ʈ</h2></center>");
			out.println("�ٽ� �湮���ּż� �����մϴ�.<HR>");		
			out.println("<a href=CookieTest>visit again</a>");
			
			out.println("</body></html>");
		}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=euc-kr");
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//��Ű ����
		Cookie idCookie = new Cookie("login", id);
		idCookie.setMaxAge(-1); //��Ű �����ð� ����
								//�ʴ��� ex)60*60*24*365 1��, -1�̸� ���������� �� ������

		Cookie passCookie = new Cookie("pass", pass);
		passCookie.setMaxAge(-1);
		
		//���䰴ü�� ��Ű �߰�
		response.addCookie(idCookie);
		response.addCookie(passCookie);

		out.println("<html><body>");
		out.println("<h1>Cookie Saved.</h1>");
		out.println("<hr><a href=CookieTest>visit again</a>");
		out.println("</body></html>");   
	}

}
