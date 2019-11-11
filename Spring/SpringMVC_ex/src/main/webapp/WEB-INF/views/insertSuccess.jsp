<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<center>
<h1>
	New Customer Added! 
</h1>
추가된 데이터는 다음과 같습니다.<br>
<table border="1">
		<tr>
			<td>${c.num }</td>
			<td>${c.name }</td>			
			<td>${c.address }</td>			
		</tr>		
</table>
<br>

<a href="list.mvc">back</a>&nbsp;&nbsp;

</center>
</body>
</html>






