<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>새고객정보입력</h1>
	<form action="main.do?action=insertProcess" method="post">
		번호:<input type="text" name="num"><br>
		이름:<input type="text" name="name"><br>
		주소:<input type="text" name="address"><br>
		<input type="submit" value="전송">
		<input type="reset" value="취소">
	</form>
</body>
</html>