<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 
1.login.jsp에서 넘어온 파라메터 받기
2.받아온 값을 세션에 저장하기
3.링크눌러서 check.jsp로 넘어가기
--%>
<%
	request.setCharacterEncoding("EUC-KR");//한글안깨지게 받기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	//세션에 저장하기
	session.setAttribute("id", id);
	session.setAttribute("pass", pass);
	
	ArrayList<String> list = new ArrayList<>();
	list.add("red");
	list.add("green");
	list.add("blue");
	list.add("yellow");
	list.add("cyan");
	list.add("magenta");
	
	session.setAttribute("list",list); //객체 저장
%>
<a href="check.jsp">check.jsp</a>
</body>
</html>