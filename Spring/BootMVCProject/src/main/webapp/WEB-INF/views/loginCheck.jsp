<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty id }">
환영합니다, ${id }님!
<a href="logout.cus">로그아웃</a><br>
</c:if>

<c:if test="${empty id }">
<a href="login.cus">로그인</a><br>
</c:if>
</body>
</html>