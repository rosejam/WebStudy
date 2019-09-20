<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.ArrayList, com.tier3.Customer"%>
<!DOCTYPE html>
<html>
<body>
<%
	ArrayList<Customer> list = (ArrayList<Customer>)request.getAttribute("list"); //String이 아니라는 것을 표시
%>
<h1>Customer Data</h1>
<table border="1">
	<%for(Customer c : list){ %>
		<tr>
			<td><%= c.getNum() %></td>
			<td><%= c.getName() %></td>
		</tr>
	<%}%>
</table>
</body>
</html>