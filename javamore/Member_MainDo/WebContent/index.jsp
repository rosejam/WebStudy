<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<p> 현재 시간 : <%=new java.util.Date().toLocaleString()%></p>
	<p> <a href='main.do?action=memberRegistForm.do'>회원가입</a></p><%-- 겟방식으로 전달 --%>
</body>
</html>



