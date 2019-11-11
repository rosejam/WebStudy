<%@ page contentType="text/html; charset=euc-kr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<center>
<h1>
	Login 
</h1>
<!-- form: 클라이언트가 입력한 값을 서버로 전송하기 위한 태그 -->
<form action="login.bod" method="post">
	id: <input type="text" name="id"><br>
	pass: <input type="password" name="pass"><br>
		
	<input type="submit" value="login">
	<input type="reset" value="cancel">
</form>



</center>
</body>
</html>






