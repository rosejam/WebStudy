<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거 있으면 세션 사용 못함 --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<center>
<h1>Customer Data</h1>
<img src="resources/img/f1.jpg"><br>
<jsp:include page="loginCheck.jsp"/>
<%-- <%@ include file="loginCheck.jsp" %> 왠지모르지만 이거 쓰면 에러남--%>
<table border="1">
	<c:forEach items="${list }" var="c">
		<tr>
			<td>${c.num }</td>
			<td><a href="detail.cus?num=${c.num }">${c.name }</a></td>
		</tr>
	</c:forEach>			
</table>
<br>
<a href="insert.cus">add customer</a>
</center>
</body>
</html>
