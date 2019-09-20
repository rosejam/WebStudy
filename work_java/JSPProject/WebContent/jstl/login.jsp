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
	<form action="process.jsp" method="post">
		아이디:<input type="text" name="id"><br>
		패스워드:<input type="password" name="pass"><br>
		<input type="submit" value="전송">
		<input type="reset" value="취소">	
	</form>
</body>
</html>