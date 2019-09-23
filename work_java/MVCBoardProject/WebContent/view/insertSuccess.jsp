<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<body>

<h1>Board Insert Success</h1>
<table border="1">
		<tr>
			<th>TITLE</th>
			<th>NAME</th>
			<th>PASS</th>
			<th>CONTENT</th>
		</tr>
		<tr>
			<td>${b.title }</td>
			<td>${b.name }</td>
			<td>${b.pass }</td>
			<td>${b.content }</td>
		</tr>
</table>
<br>
<a href="list.bod">초기화면</a>
</body>
