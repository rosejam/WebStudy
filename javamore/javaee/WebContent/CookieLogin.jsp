<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty cookie.idsave }">
	<c:set var="idsave" value='${cookie.idsave.value }'/>
	<c:set var="checked" value='checked="checked"'/>
</c:if>
<form method="post"  action="cookielogin.do">
	<table align="center" border="1">
		<tr><td>아 이 디</td>
		<td><input type="text" name="id" value="${idsave }"></td></tr>
		<tr><td>비밀번호</td>
		<td><input type="password" name="password"></td></tr>
		<tr>
			<td colspan="2"  align="right">
			  아이디 저장<input type="checkbox" name="idsave" value="t" ${checked }  />
			  <input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
</body>
</html>

	





