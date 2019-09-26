<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${param.id } <br/>
	취 미 : ${param.hobby } <br/>
	취 미 : ${paramValues.hobby[0]},${paramValues.hobby[1]},${paramValues.hobby[2]} <br/> <%-- null은 자동으로 처리 --%>
	queryString : ${pageContext.request.queryString } <br/>
	cookie 정보 : ${cookie.JSESSIONID.value }
</body>
</html>



