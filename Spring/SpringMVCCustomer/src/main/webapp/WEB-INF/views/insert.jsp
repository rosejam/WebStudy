<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<center>
<h1>
	Add New Customer Data 
</h1>
<!-- form: 클라이언트가 입력한 값을 서버로 전송하기 위한 태그 -->
<form action="insert.cus" method="post">
	num: <input type="text" name="num"><br>
	name: <input type="text" name="name"><br>
	address: <input type="text" name="address"><br>
	
	<input type="submit" value="add data">
	<input type="reset" value="cancel">
</form>

</center>
</body>
</html>






