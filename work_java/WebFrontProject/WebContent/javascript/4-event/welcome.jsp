<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>
<a href="p76_formtest.html">back</a><br>
<%
	//이전 html문서에서 클라이언트가 입력한 값을 받아오기!!!!
	String num = request.getParameter("num"); //괄호안에 "이름"
	String choice = request.getParameter("choice");
	String season= request.getParameter("season");
	
	//checkbox의 경우 --> check된 아이템만 넘어옴
	String[] hobby= request.getParameterValues("hobby"); //체크된게 많아서

	out.println("num:"+num+"<br>"); //브라우저에 출력 - "\n"아니고 "<br>"
	out.println("choice:"+choice+"<br>"); //one/two/three
	out.println("season:"+season+"<br>");

	for(String ho: hobby){
		out.println("hobby:"+ho+"<br>");
	}
%>
</body>
</html>