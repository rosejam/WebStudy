<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--
	String id = (String)session.getAttribute("id");
	if(id != null){ %>
		<%=id %>님, 환영합니다. 
		<a href="logout.cus">로그아웃</a><br>
<% 	}else{%>
		<a href="login.cus">로그인</a><br>
<% 	} --%>
<c:if test="${not empty id }">
환영합니다, ${id }님!
<a href="logout.cus">로그아웃</a><br>
</c:if>

<c:if test="${empty id }">
<a href="login.cus">로그인</a><br>
</c:if>
</body>
</html>