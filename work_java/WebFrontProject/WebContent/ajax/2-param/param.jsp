<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
//java code 적는 곳
	//client가 보내온 데이터 받기
	//주소창에 ?name=동주&address=서울 로 데이터를 직접 넣어 확인한다. (?와 &들로 데이터 구분)
	String name = request.getParameter("name"); //이름으로 데이터를 받아온다
	String address = request.getParameter("address");
	out.println("hello... "+name+"<br>"); //클라이언트에 보내기
	out.println("you live in "+address+"<br>");
	




%>