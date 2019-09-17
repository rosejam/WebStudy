<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>welcome, <%= request.getParameter("id") %>!!!</h1>
<h1>your password is... <%= request.getParameter("pass") %></h1>
<a href="login.html">back</a>
</body>
</html>