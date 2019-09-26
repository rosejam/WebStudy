<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.user == 'member' }">
		<jsp:include page="../Login.jsp"/>
	</c:if>
	<c:if test="${param.user == 'guest' }">
		<jsp:include page="../memberRegister.html"/>
	</c:if>
	<c:if test="${param.user != 'guest' and param.user != 'member'}">
		<p>잘못 입력했습니다</p>
	</c:if>
<br/>
<a href="IfTest.html">다시 입력하기.</a>
</body>
</html>







