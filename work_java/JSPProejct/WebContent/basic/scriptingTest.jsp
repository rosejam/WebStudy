<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>scripting test</h1>
<%-- 선언: jsp파일이 변환되어 생기는 자바 파일의 "멤버 필드/메소드 선언" 시 사용 --%>
<%!
	int big = 999;
	public String hello(String name){
		return "hello," + name;
	}
%>

<%-- 식: 변수값, 계산 결과, 메소드 호출 결과를 "출력"할 때 사용. ;을 붙이지 않음 --%>
result: <%= big%><br>
result2: <%= hello("kim") %><br>
<hr>

<%-- 스크립트렛: 자바코드 적는 영역 --%>
<%
	if(big > 1000){
		out.println("level-1"); //out은 내장 객체
	}else{
%>
<%= "level-2" %>
<%	
	}
%>
</body>
</html>