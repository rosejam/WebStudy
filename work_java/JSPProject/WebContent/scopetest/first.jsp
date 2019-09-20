<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>first</h1>
<%
	request.setAttribute("rdata", "100");
	session.setAttribute("sdata", "200");
	application.setAttribute("adata", "300");
%>
request data: <%= request.getAttribute("rdata") %><br>
session data: <%= session.getAttribute("sdata") %><br>
application data: <%= application.getAttribute("adata") %><br>

<a href="second.jsp">second</a>
</body>
</html>