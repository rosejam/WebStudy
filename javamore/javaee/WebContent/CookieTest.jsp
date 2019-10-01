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
	<%
		Cookie[] cookies = request.getCookies();
		pageContext.setAttribute("cookies", cookies);
	%>
	<%-- 발급된 쿠키 추출 --%>
	<c:choose>
		<c:when test="${!empty cookies }">
			<c:forEach items="${cookies }" var='c'>
				<p>쿠키이름 :${c.name }	쿠키값 :${c.value }</p>
			</c:forEach>
		</c:when>
	</c:choose>
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



