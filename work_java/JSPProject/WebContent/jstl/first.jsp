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
<%-- set:변수 선언 --%>
<c:set var="num" value="${2 + 5 }"/>
<c:set var="name" value="${'jane' }"/>

<c:out value="${num }"/><br>
${name }

</body>
</html>