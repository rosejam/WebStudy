<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.dao.CustomerDAO"%>
<!DOCTYPE html>
<html>
<body>
<%--
	Customer c = (Customer)request.getAttribute("c");	
--%>
<h1>등록된 고객정보</h1>
<table border="1">
		<tr>
			<td>${c.num }</td>
			<td>${c.name }</td>
			<td>${c.address }</td>
		</tr>
</table>
<br>
<a href="main.do">초기화면</a>
</body>
</html>