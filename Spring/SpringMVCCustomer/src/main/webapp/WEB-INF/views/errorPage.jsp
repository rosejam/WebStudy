<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> 이거 있으면 세션 사용 못함 --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Error 발생!  
</h1>

<P> ${emsg } </P>
<a href="list.cus">back</a>
</body>
</html>
