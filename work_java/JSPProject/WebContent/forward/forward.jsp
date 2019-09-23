<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- 이전 화면에서 넘어온 파라메터 값에 따라 welcome.jsp나 login.html로 forward 시킴 --%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if(id.equals("tommy") && pass.equals("123")){ //맞을 때
%>
	<jsp:forward page="welcome.jsp">
		<jsp:param value="<%= id %>" name="id" />
		<jsp:param value="<%= pass %>" name="pass" />
	</jsp:forward>
<%	}else{ %> 
	<jsp:forward page="login.html"/>
<%	}%>
</body>
</html>