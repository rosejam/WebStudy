<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.model.domain.Goods" %>
<%
	Goods goods = new Goods(1,"hadoop",15000,10,0);
	pageContext.setAttribute("goods", goods);
	
	String[] music={"숨","좋니","빨간맛","야생화"};
	pageContext.setAttribute("music",music);
	
	pageContext.setAttribute("proname","quantity");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>















