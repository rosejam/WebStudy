<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	    //발급된 쿠키 추출
		
	%>
	<form action="cookietest.do" method="post">
		<table  align="center">
			<tr><td>쿠키이름</td>
			    <td><input type="text" name="cookiename" id="cookiename"/></td>
			</tr>
			<tr><td>쿠키값</td>
			    <td><input type="text" name="cookievalue" id="cookievalue"/></td>
			</tr>
			<tr><td colspan="2" align="right">
			     <input type="submit" value="전송"/></td>
			</tr>
		</table>
	</form>
</body>
</html>



