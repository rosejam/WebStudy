<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="../basic/error.jsp"%>
<!DOCTYPE html>
<html>
<body>
<%-- html에서 전송된 값 받아와서 화면에 출력 --%>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String code = request.getParameter("code"); 
	int cnum = Integer.parseInt(code); //code가 문자열이라면 parseInt가 불가능해서 500번(서버에러)이 발생
	cnum++;	
%>
	ID: <%= id %><br>
	PASS: <%= pass %><br>
	CODE: <%= cnum %><br>
	<hr>
	<a href="login.html">back</a>
</body>
</html>