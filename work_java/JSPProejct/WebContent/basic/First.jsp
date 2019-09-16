<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!--  html 주석(소스에 들어간다 ->에러가 생길 가능성이 있음!!) -->
	<%-- jsp 주석(소스에 추가되지 않는다. ->사용 추천) --%>
	<h1>hello, jsp</h1>
	<% 
		//자바 코드
		int num=99;
		if(num>100)
			out.println("big number");
		else
			out.println("small number");
	%>
</body>
</html>