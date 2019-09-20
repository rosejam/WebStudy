<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>
<!-- 500error가 발생하지만 web.xml에 오류 처리했으므로 
     ErrorHandler.jsp가 화면에 표시된다. -->
	<%	int result = 256 /0;	%>
</body>
</html>