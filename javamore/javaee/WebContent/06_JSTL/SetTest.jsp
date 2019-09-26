<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>
<!-- 특정 scope에 객체가 있으면 추출, 없으면 생성해서 저장 -->
<jsp:useBean id="goods" class="com.ssafy.model.domain.Goods" scope='page'/>

<!-- 특정 scope에 저장된 객체의 속성 정보 변경 -->
<c:set target='${goods }' property="proname" value='샌드위치'/>
<c:set target='${goods }' property="quantity" value='3'/>
	상품이름 : ${goods.proname} <br/>
	상품수량 : ${goods.quantity}<br/>

<!-- 특정 scope에 문자열로 데이터 저장(숫자인 경우 연산 가능) -->
<c:set var='total' value='0'/>
<c:set var='price' value='5000,3000,2000,10000'/>

<c:forEach var='p' items="${price }">
	<p>단가 : ${p } 주문 가격 : ${p*goods.quantity } </p>
	<c:set var='total' value='${total+ p*goods.quantity}'/> <!-- 있으므로 값 변경 -->
</c:forEach>	
	총 가격 : ${total}
</body>
</html>