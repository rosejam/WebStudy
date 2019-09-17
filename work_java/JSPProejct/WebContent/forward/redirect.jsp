<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("tommy") && pass.equals("123")){ //맞을 때
		response.sendRedirect("welcome.jsp");
	}else{ 
		response.sendRedirect("login.html");
	}
%>
</body>
</html>