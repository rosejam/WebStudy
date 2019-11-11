<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<center>
<h1>
	Customer Detail 
</h1>

<table border="1">
		<tr>
			<td>${c.num }</td>
			<td>${c.name }</td>			
			<td>${c.address }</td>			
		</tr>		
</table>
<br>

<a href="list.mvc">back</a>&nbsp;&nbsp;
<a href="delete.mvc?num=${c.num }">delete</a>
</center>
</body>
</html>






