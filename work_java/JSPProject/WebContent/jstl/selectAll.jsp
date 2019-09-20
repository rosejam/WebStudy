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
<%@ include file="dbInfo.jsp" %> <%--ds및 sql taglib를 복붙 --%>

<sql:query var="rs" dataSource="${ds }"><%-- var에는 결과가 들어간다. --%>
	select * from customer order by num
</sql:query>
<h1>customer data</h1>
<table border="1">
	<c:forEach items="${rs.rows }" var="row"><%--포이치 문 items에는 배열또는 ArrayList등 --%>
		<tr>
			<td>${row.num }</td>
			<td>${row.name }</td>
			<td>${row.address }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>