<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>session 값 삭제</h1>
<%--
1.세션에 저장되어 있는 값 삭제
2.링크걸어 login.jsp, check.jsp로 넘어가기
--%>
<%
	session.setAttribute("id", null);
	session.setAttribute("pass", null);
%>
<a href="login.jsp">login.jsp</a>
<a href="check.jsp">check.jsp</a>
</body>
</html>