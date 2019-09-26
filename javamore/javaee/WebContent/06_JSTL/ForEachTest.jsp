<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,com.ssafy.model.domain.Goods"
    %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<%
    String[] prices={"5000","3000","10000","500"};

    String  price2="5000,3000,10000,500"; //배열이 아니지만 포이치문 가능. []는 사용불가
	ArrayList<Goods> list = new ArrayList<Goods>();
	list.add(new Goods(1,"a1",5000,10,0));
	list.add(new Goods(2,"a2",10000,100,0));
	list.add(new Goods(3,"a3",3000,50,0));
	list.add(new Goods(4,"a4",50000,200,0));
	
	pageContext.setAttribute("price2", price2);
	pageContext.setAttribute("prices", prices);
	pageContext.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach begin="1" end='5' varStatus="cnt">
		${cnt.count }
	</c:forEach>
	<br/>
	<c:forEach items='${prices }' var="p">
		${p }
	</c:forEach>
	<br/>
	<c:forEach items='${prices }' var="p">
		${p }
	</c:forEach>
	<br/>
	
	<!-- 문자열이지만 ,로만 구분된 경우 forEach를 통해 반복 처리 할 수 있다. -->
	<c:forEach items='${price2 }' var="p">
		${p }
	</c:forEach>
	
	<br/>
	<c:forEach items='${list }' var="g" varStatus="seq" begin="2" end="4">
		순번 : ${seq.count } <%-- 자동 --%>
		이름 : ${g.proname }
		단가 : ${g.proprice }
		수량 : ${g.quantity }
		금액 : ${g.total }
		<br/>
	</c:forEach>
</body>
</html>




