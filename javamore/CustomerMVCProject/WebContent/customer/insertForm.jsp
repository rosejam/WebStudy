<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<body>
		<h1>새고객등록</h1>
		<form action="insertProcess.cus" method="post" id="f">
			<hr>
			NUM : <input type="text" name="num" id="num">
			<br>
			NAME : <input type="text" name="name" id="name">
			<br>
			ADDRESS : <input type="text" name="address" id="address">
			<hr>
			<a href="insertProcess.cus?num=">
				<input type="submit" value="전송">
			</a>
			<input type="reset" value="취소">
		</form>
	</body>
</html>