<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="head">
	<jsp:include page="/menu.jsp"/>
</div>
<article id="content"> 
	<jsp:include page="/aside.jsp"/>
		<article id="mainContent">
			<form method="post" action="insertMember.do">
				<table align='center'>
					<tr>
						<td class="caption" colspan='2' align='center'>회원가입</td>
					</tr>
					<tr>
						<td class='tbasic'>아 이 디</td>
						<td class='tbasic'><input type='text' name='id' id='id'></td>
					</tr>
					<tr>
						<td class='tbasic'>비밀번호</td>
						<td class='tbasic'><input type='password' name='password'
							id='password'></td>
					</tr>
					<tr>
						<td class='tbasic'>이 &nbsp;름</td>
						<td class='tbasic'><input type='text' name='name' id='name'></td>
					</tr>
					<tr>
						<td class='tbasic'>이메일</td>
						<td class='tbasic'><input type='text' name='email' id='email'>
					</tr>
					<tr>
						<td class='tbasic'>주 &nbsp;소</td>
						<td class='tbasic'><input type='text' name='address'
							id='address'>
					</tr>
					<tr>
						<td colspan='2' align='center' class='tfoot tspacial'><input
							type="submit" value='회원등록'><input type="reset" value='취소'>
						</td>
					</tr>
				</table>
			</form>
		</article>
	</article>
	<footer id="copyright">
		<jsp:include page="/copyright.jsp" />
	</footer>
</body>
</html>
