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
<img src="resources/img/f1.jpg">

<table border="1">
	<c:forEach items="${list }" var="c">
		<tr>
			<td>${c.num }</td>
			<td>${c.name }</td>
			<td>${c.address }</td>
		</tr>
	</c:forEach>			
</table>
<br>
<a href="insert.cus">add customer</a>
</center>
</body>
</html>
