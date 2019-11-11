<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<center>
<h1>
	Customer Data 
</h1>
<img src="resources/img/f1.jpg"><br>
<table border="1">
	<c:forEach items="${list }" var="row">
		<tr>
			<td>${row.num }</td>
			<td><a href="detail.mvc?num=${row.num }">${row.name }</a></td>			
		</tr>	
	</c:forEach>
</table>
<br>
<a href="insert.mvc">add new customer</a>
</center>
</body>
</html>






