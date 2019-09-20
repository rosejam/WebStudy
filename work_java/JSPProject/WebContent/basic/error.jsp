<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<%-- isErrorPage는 에러 처리 페이지에서 꼭 해줘야하는 속성. 안적혀있다면 기본 false로 되어있음 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>예외 발생</h1>
	message: <%= exception.getClass().getName() %>
</body>
</html>