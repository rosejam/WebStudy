<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<table>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${phones }" var="phone">
			<tr>
				<td><a href="detail.do?num=${phone.num }">${phone.num }</a></td>
				<td>${phone.model }
				<td>${phone.price }</td>
				<td>${phone.company.vendor }</td>
				<td><input type="checkbox" data-num="${phone.num }"></td>
			</tr>
		</c:forEach>
	</table>
	<a href="regPhone.do">추가 등록</a>&nbsp;
	<a href="" id="selectedDel">선택항목삭제</a>
</body>
<script type="text/javascript">
	
	//이거뭔가 문제 발생. 다르게 전달하는것이 더좋다고 들음
	$("#selectedDel").on("click", function(e){
		e.preventDefault();
		let url = "delete.do?"
		$(":checkbox:checked").each(function(idx, item){
			url+="num="+$(item).attr("data-num")+"&";
		});
		url = url.substring(0,url.length -1);//url -= "&";//
		location.href=url;
	});
	
</script>
</html>