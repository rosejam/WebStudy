<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html><head><meta charset="UTF-8"><title>Insert title here</title></head>
<body>

	상품이름 : ${goods.proname} <br/>
	상품수량 : ${goods.quantity}<br/>
	
	총 가격 : ${total}
</body>
</html>