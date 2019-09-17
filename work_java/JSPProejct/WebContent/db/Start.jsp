<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%! 
	//선언
	//나중에 tomcat에 의해 생성되는 서블릿 클래스의 "멤버 필드"로 들어감
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String query = "select num, name from customer";
%>
<%
	//try catch는 자동으로 추가됨
	//1. Driver 등록=로딩
	Class.forName(driver);
	
	//2. Connection 생성
	Connection con = DriverManager.getConnection(url, user, password);
	
	//3. Statement 생성
	Statement stat = con.createStatement();
	
	//4. Query 실행
	ResultSet rs = stat.executeQuery(query);
%>	
	<table border=1>
	<tr><th>번 호</th><th>이 름</th></tr>
<%
	//5. 결과 처리
	while(rs.next()) { //제목 줄이 아닌 그다음 줄 부터 처리하게 된다.
		String num = rs.getString(1);
		String name = rs.getString(2);
%>		
		<tr><td><%= num %></td><td><a href=Detail.jsp?num=<%= num %>><%= name %></a></td></tr>
<%	} %>
	</table>
	<br>
	<a href="insertForm.jsp">고객등록</a>
<%
	//6. 마무리 
	rs.close();
	stat.close();
	con.close();
%>
