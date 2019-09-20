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
	<p><a href="memberRegitForm.do">회원 등록</a></p>
	<p><a href="loginForm.do">로그인</a></p>
	<p><a href="goodsList.do">상품목록</a></p>
</body>
</html>



