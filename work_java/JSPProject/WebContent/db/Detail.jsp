<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%! 

	//멤버필드
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String query = "select * from customer where num=?";
%>
<%
	//1. Driver 등록
	Class.forName(driver);
	
	//2. Connection 생성
	Connection con = DriverManager.getConnection(url, user, password);
	
	//3. PreparedStatement 생성
	PreparedStatement pstat = con.prepareStatement(query);
	
	//3-1. ?에 값 setting
	pstat.setString(1, request.getParameter("num")); //전달된 num을 쿼리에
	
	//4. Query 실행
	ResultSet rs = pstat.executeQuery();
	
	//5. 결과 처리
	rs.next(); //record하나만 있는 경우지만, rs는 제목줄을 가르키고 있으므로 꼭 이작업을 해주어야 내용을 제대로 가르킨다!!
	
	String num = rs.getString(1);
	String name = rs.getString(2);
	String address = rs.getString(3);
%>	
	<table border=1>
	<tr><th>번 호</th><td><%= num %></td></tr>
	<tr><th>이 름</th><td><%= name %></td></tr>
	<tr><th>주 소</th><td><%= address %></td></tr>
	</table>
	
	<br><a href=JDBCServlet>back</a>
<%
	//6. 마무리 
	rs.close();
	pstat.close();
	con.close();
%>

