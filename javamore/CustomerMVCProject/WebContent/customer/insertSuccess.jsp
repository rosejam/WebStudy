<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.dao.Customer"%>
<!DOCTYPE html>
<html>
	<body>
	<%
		Customer c = (Customer)request.getAttribute("c");	
	%>
	<h1>Customer Insert Data</h1>
		<table border="1">
				<tr>
					<td><%= c.getNum() %></td>
					<td><%= c.getName() %></td>
					<td><%= c.getAddress() %></td>
				</tr>
		</table>
		<br>
		<a href="list.cus">초기화면</a>
		
	</body>
</html>