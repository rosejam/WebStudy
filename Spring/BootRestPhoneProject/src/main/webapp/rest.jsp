<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form>label {
	display: inline-block;
	width: 100px;
}

form>:input {
	display: inline-block;
	width: 100px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:url value="/phone" var="phone" />
	<h1>휴대전화 목록</h1>
	<table border="1">
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
		</tr>
		<tbody id="list">
		</tbody>
	</table>
	<div id="status"></div>
	<h1>휴대전화 정보</h1>
	<form id="phoneForm">
		<label for="num">모델번호</label>
		<input type="text" name="num" id="num">
		<br>
		<label for="model">모델명</label>
		<input type="text" name="model" id="model">
		<br>
		<label for="price">가격</label>
		<input type="number" name="price" id="price">
		원 <br>
		<label for="vcode">제조사</label>
		<select id="vcode" name="vcode">
			<option value="10">삼성
			<option value="20">엘지
			<option value="30">애플
		</select>
		<br>
		<input type="button" value="추가하기" id="btnInsert">
		<input type="button" value="수정하기" id="btnModify">
		<input type="button" value="삭제하기" id="btnDelete">

	</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function list() {
		$("#status").html("");
		$.ajax({
			url : "${phone}",
			type : "get",
			success : function(resTxt) {
				console.log(resTxt);
				if (resTxt.isOk) {
					$("#list").empty();
					$(resTxt.data).each(function(idx, phone) {
						//console.log(idx, phone);
						let $tr = $("<tr>");
						$tr.append("<td class='num'>" + phone.num + "</td>");
						$tr.append("<td>" + phone.model + "</td>");
						$tr.append("<td>" + phone.price + "</td>");
						$tr.append("<td>" + phone.company.vendor + "</td>");
						$("#list").append($tr);
					})
					$("#status").html("조회 성공: " + resTxt.data.length);
				} else {
					$("#status").html("조회 실패: " + resTxt.data);
				}
			},
			error : function() {
				alert("조회 실패(시스템 오류)");
			}
		});
	}
	list();

	$("#list").on("click", ".num", function() {
		$("#status").html("");
		let num = $(this).text();
		$.ajax({
			url : "${phone}/" + num,
			success : function(resTxt) {
				if (resTxt.isOk) {
					console.log(resTxt);
					$("#num").val(resTxt.data.num);
					$("#model").val(resTxt.data.model);
					$("#price").val(resTxt.data.price);
					$("#vcode").val(resTxt.data.vcode);
					$("#status").html("조회 성공: ");
				} else {
					$("#status").html("조회 실패: " + resTxt.data);
				}
			},
			error : function() {
				alert("조회 실패(시스템 오류)")
			}
		});
	});
	
	$("#btnInsert").on("click", function(){
		$("#status").html("");
		let phone = {num:$("#num").val(), model:$("#model").val(), price:$("#price").val(), vcode:$("#vcode").val() };
		
		$.ajax({
			url : "${phone}",
			type: "post",
			data: JSON.stringify(phone),
			contentType:"application/json",
			success : function(resTxt) {
				if (resTxt.isOk) {
					list();					
				} else {
					$("#status").html("추가 실패: " + resTxt.data);
				}
				clearField();
			},
			error : function() {
				alert("실패 실패(시스템 오류)")
			}
		});
	});
	
	$("#btnModify").on("click", function(){
		$("#status").html("");
		let phone = {num:$("#num").val(), model:$("#model").val(), price:$("#price").val(), vcode:$("#vcode").val() };
		
		$.ajax({
			url : "${phone}",
			type: "put",
			data: JSON.stringify(phone),
			contentType:"application/json",
			success : function(resTxt) {
				if (resTxt.isOk) {
					list();					
				} else {
					$("#status").html("수정 실패: " + resTxt.data);
				}
				clearField();
			},
			error : function() {
				alert("실패 실패(시스템 오류)")
			}
		});
	});
	
	$("#btnDelete").on("click", function(){
		$("#status").html("");
		let num = $("#num").val();		
		$.ajax({
			url : "${phone}/"+num,
			type: "delete",
			success : function(resTxt) {
				if (resTxt.isOk) {
					list();					
				} else {
					$("#status").html("삭제 실패: " + resTxt.data);
				}
				clearField();
			},
			error : function() {
				alert("실패 실패(시스템 오류)")
			}
		});
	});
	
	function clearField(){
		$("#num").val("");
		$("#model").val("");
		$("#price").val("");
		$("#vcode").val("10");
	}
</script>
</html>