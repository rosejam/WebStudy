<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    Forward로 이동한 페이지 <br/>
	아이디 :<%=request.getParameter("id")%> <br/>
	메세지 :<%=request.getAttribute("msg")%><br/> 
	
</body>
</html>




