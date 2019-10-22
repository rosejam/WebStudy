<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거 있으면 세션 사용 못함 --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<center>
<h1>Customer Registered</h1>
<img src="resources/img/f3.jpg">
<h1>등록된 고객 정보</h1>
<table border="1">
	<tr>
		<td>${c.num }</td>
		<td>${c.name }</td>
		<td>${c.address }</td>
	</tr>
</table>
<br>
<a href="list.cus">back</a>

</center>
</body>
</html>
