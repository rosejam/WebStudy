<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거 있으면 세션 사용 못함 --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<center>
<h1>Customer Detail Data</h1>
<img src="resources/img/f2.jpg"><br>
<jsp:include page="loginCheck.jsp"/>
<%-- <%@ include file="loginCheck.jsp" %> --%>
<table border="1">
	<tr>
		<td>${c.num }</td>
		<td>${c.name }</td>
		<td>${c.address }</td>
	</tr>
</table>
<br>
<a href="list.cus">back</a>
<a href="delete.cus?num=${c.num }">delete</a>
</center>
</body>
</html>
