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
	상품 이름 :    ${pageScope['goods'].proname}
				,${pageScope.goods.proname}
				,${goods.proname}
				,${goods['proname']}  	<br/>
	상품 수량 :	 ${goods[proname]} <%-- 따옴표가 없어서 변수로 인식 --%><br/>
	
	music: ${pageScope['music']['0'] }
	music: ${music['0'] }
	music: ${music[0] }
</body>
</html>















