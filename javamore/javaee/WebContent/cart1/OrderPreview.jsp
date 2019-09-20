<%@ page import="java.util.Collection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.ssafy.model.domain.Goods,java.util.*"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int totalPrice=0 ; %>
<table align="center">
	<tr><td width="200">상품이름</td>
        <td width="100">단가</td>
        <td width="100">개수</td>
        <td width="100">금액</td>
    </tr>   
    <tr><td></td>
    	<td></td> 
    	<td></td> 
    	<td></td> 
    <tr><td colspan="3"  align="right">주문한 총 금액</td>
    	<td></td>    
    </tr> 
   
    <tr><td colspan='4' align="center"><a href='goodsList.do'>책</a></td></tr>
</table>
</body>
</html>


