<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%-- import="java.util.ArrayList, com.dao.Customer"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--초기화면 --%>
<html>
<body><center>   
<%--
	ArrayList<Customer> list = (ArrayList<Customer>)request.getAttribute("list");	
--%>
<h1>Customer Data</h1>
<%@ include file="loginCheck.jsp" %>
<table border="1">
	<%-- for(Customer c: list){ %>
		<tr>
			<td><%= c.getNum() %></td>
			<td><a href="read.cus?num=<%= c.getNum() %>"><%= c.getName() %></a></td><!-- 번호정보를 가지고 read로 가도록함 -->
		</tr>
	<%} --%>
	<c:forEach items="${list }" var="c"> <%-- request>session>application순서대로 뒤지면서 list를 알아서 찾는다 --%>
		<tr>
			<td>${c.num }</td>
			<td><a href="read.cus?num=${c.num }">${c.name }</a></td> <%-- read.cus로 num을 Parameter로 전달!! --%>
		</tr>	
	</c:forEach>
</table>
<a href="insert.cus">새고객등록</a>
</body>
</html>
