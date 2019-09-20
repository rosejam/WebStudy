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
<c:set var="num" value="${param.num }"/>
<c:if test="${empty num }">
	null 입니다
</c:if>

<c:if test="${num > 100 }">
	big number<br>
</c:if>

<c:if test="${num eq 100 }">
	good number<br>
</c:if>

<c:if test="${num lt 100 }">
	small number<br>
</c:if>
</body>
</html>