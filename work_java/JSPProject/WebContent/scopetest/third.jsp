<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>third</h1>
request data: <%= request.getAttribute("rdata") %><br>
session data: <%= session.getAttribute("sdata") %><br>
application data: <%= application.getAttribute("adata") %><br>

<a href="first.jsp">second</a>
</body>
</html>