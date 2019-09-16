package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/ServletProject(=프로젝트 이름이 아니고 컨텍스트 루트 이름!)/HelloServlet
// @WebServlet : 이 클래스가 서블릿이라는 뜻
// "/HelloServlet" : 이 클래스의 url mapping값
@WebServlet("/Hello") //이 Annotation은 지우면 안됨!
public class HelloServlet extends HttpServlet {
	
	//service 메소드 : 클라이언트로부터 "요청이 들어오면 응답"을 만들어 내는 메소드(doGet()/doPost())
	//클라이언트로부터 서버로 들어오는 "요청의 방식"에 따라 "<서비스 메소드>가 결정"됨
	//get방식 : "브라우저에서 직접 url 입력"해서 요청을 보낼 때, link눌러서 이동할 때
	//post방식 : form을 사용하면서 메소드를 post로 지정한 경우 밖에 없다.
	//			<form action=".jsp" method="post"></form>
	
	
	//request: 클라이언트로부터 서버로 들어오는 "요청"정보가 들어있는 객체(form태그 안의 내용 등)
	//response: 서버에서 클라이언트로 나가는 "응답"정보가 들어있는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//서버에서 클라이언트로 나가는 응답의 "컨텐트 타입 지정!"
		//컨텐트 타입(text/html):"MIME TYPE" 문서 종류 - pdf,ppt등 web.xml에서 검색
		response.setContentType("text/html;charset=euc-kr"); //한글처리
		
		//클라이언트로 보낼 컨텐츠 출력을 위한 "출력 스트림 준비!"(response에서 출력용 파이프를 가져옴)
		PrintWriter out = response.getWriter();
		
		System.out.println("HelloServlet");
		
		//클라이언트는 컨텐트 타입을 미리 말해주었기 때문에 태그인식을 할 것임(JSP는 이부분이 간단해짐), 브라우저에 출력
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>hello servlet 입니다</h1>");
		out.println("<a href=MessageServlet>go to messageServlet</a>"); //href 링크에 url mapping값을 넣는다~
		out.println("<br><a href=LoginServlet?id=tommy&pass=123&code=qqq>go to LoginServlet</a>"); //url뒤에 데이터 파라메터를 보낼 수 잇다. 
		out.println("</body>");
		out.println("</html>");
	}
}
