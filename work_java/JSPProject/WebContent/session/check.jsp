<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>session에서 값 꺼내기</h1>
<%-- 
1.session에 저장된 값 꺼내서 출력
2.링크걸어서 delete.jsp로 넘어가기 
--%>
<%
	String id = (String)session.getAttribute("id");
	String pass = (String)session.getAttribute("pass");
%>
안녕하세요? <%= id %>님!<br>
패스워드는 <%= pass %>입니다.<br>
<h3>list 내용</h3>
<%
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
	for(String color: list){%>
		<%= color %>		
<%	}%>
<hr>
${sessionScope.id }<br>
${sessionScope.pass }<br>
<a href="delete.jsp">delete.jsp</a>
</body>
</html>