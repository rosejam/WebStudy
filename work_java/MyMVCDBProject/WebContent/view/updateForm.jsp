<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>수정할고객정보입력</h1>
	<form action="main.do?action=updateProcess" method="post">
		<input type="text" name="num" value="${c.num }" readonly="readonly"><br>
		<input type="text" name="name" value="${c.name }" readonly="readonly"><br>
		주소:<input type="text" name="address"><br>
		<!-- input type="hidden" name="num" value="${num }" --> <!-- hidden으로 숨겨서 파라메터 전달 -->
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>
</body>
</html>