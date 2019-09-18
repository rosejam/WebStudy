<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList, com.dao.Customer"%>

<html>
<body><center>   
<%
	ArrayList<Customer> list = (ArrayList<Customer>)request.getAttribute("list");	
%>
<h1>Customer Data</h1>
<table border="1">
	<% for(Customer c: list){ %>
		<tr>
			<td><%= c.getNum() %></td>
			<td><a href="read.cus?num=<%=c.getNum() %>"><%= c.getName() %></td>
		</tr>
	<%} %>	
</table>
<a href="insert.cus">»õ°í°´µî·Ï</a>
</body>
</html>













