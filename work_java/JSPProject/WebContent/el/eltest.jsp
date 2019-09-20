<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%--eltest.jsp?num=999을 url뒤에 붙이면 param.num이 999가 된다. --%>
${2+6} <br>
${param.num} <br>
${3 eq 5}<br>
</body>
</html>