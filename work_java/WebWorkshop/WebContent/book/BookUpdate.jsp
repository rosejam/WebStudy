<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<title>도서 등록</title>
	<META http-equiv="Content-Type" content="text/html;charset=utf-8">

	<script language="JavaScript" src="js\script.js"></script>

<style type="text/css">
h4  {
	text-align: center;
}
.isbn {
	width: 50px;
}
</style>
</head>

<body >

<!--도서등록 타이틀 테이블 시작//-->
<table width="650" cellpadding="0" cellspacing="0"  align="center" >
	<tr bgcolor="#E3E3E3">
		<td width="700"  valign="middle" >
			<center><h2>도서 수정 화면</h2></center>
		</td>
	</tr>
</table>
<!--도서등록 타이틀 끝//-->

<p>
<c:if test="${not empty user }">
<h4>${user} 님 로그인 되었습니다. <a href="main.do?action=LOGOUT">로그아웃</a></h4>
</c:if>
<!--도서정보입력 FORM 테이블시작//-->
<FORM METHOD="post" action="main.do?action=UPDATESAVE" name="bookForm" id="bookForm">

	<!--도서아이디정보 입력 테이블 시작//-->
	<Table cellpadding="0" cellspacing="1" border="0" width="650" bgcolor="#EAEAEA" align="center">
		<!-- 필수입력필드표기 -->
		<tr>
			<td width="650" bgcolor="#FFFFFF" height="35"  valign="middle" align="right" colspan="2">
				<img src="images\star_orange.gif" hspace="7" vspace="3">표시가 된 항목은 필수 입력 항목입니다.
			</td>
		</tr>	
		<tr>
			<td width="650" bgcolor="#F3F3F3" height="35" colspan="2">
			</td>
		</tr>
		<!--도서번호 입력-->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src="images\star_orange.gif" hspace="7" vspace="3">도서번호
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
				<input type="text" name="isbn"  id="isbn"  width="120"  value="${b.isbn }"  readonly="readonly">
			</td>			
		</tr>	
		<!--도서제목-->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src="images\star_orange.gif" hspace="7" vspace="3">도서제목
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type="text" name="title"  id="title" size="50" MAXLENGTH="50" tabindex="4" required="required"  value="${b.title }">&nbsp;
			</td>			
		</tr>	
		<!--도서종류-->
	    
		<!-- 저자 -->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src="images\star_orange.gif" hspace="7" vspace="3">저&nbsp;&nbsp;&nbsp;&nbsp;자
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type="text" name="author" id="author" size="10" MAXLENGTH="50" tabindex="11" value="${b.author }" >&nbsp;
			</td>			
		</tr>	

		<!-- 도서가격 -->
		<tr>
			<td bgcolor="#FFFFFF" height="35" width="120" valign="middle">
				<img src="images\square_gray.gif" hspace="7" vspace="3">&nbsp;도서가격
			</td>
			<td bgcolor="#FFFFFF" height="35">&nbsp;&nbsp;
					<input type="number" name="price" id="price" size="8" MAXLENGTH="6" tabindex="12" value="${b.price }"  >&nbsp;원
			</td>			
		</tr>	
	
		<!--요약내용-->
		<tr>
			<td bgcolor="#FFFFFF" height="60" width="120">
				<img src="images\square_gray.gif" hspace="7" vspace="3">&nbsp;요약내용
			</td>
			<td>&nbsp;&nbsp;
				<TEXTAREA NAME="description" id="description" ROWS="3" COLS="50" tabindex="14">${b.description }</TEXTAREA>
			</td>			
		</tr>	
	</table>
	<!--기본입력 테이블 끝//-->

	<br>
	<Table cellpadding="0" cellspacing="1" border="0" width="650" bgcolor="#EAEAEA" align="center">
		<tr>
			<td align="center" height="30" valign="middle">
				<input  type="submit" value="수정완료" >
				<input  type="reset"   value="취소">
			</td>
		</tr>
	</table>
</FORM>
<!--정보입력 테이블끝//-->


<CENTER>
<FONT COLOR="NAVY" SIZE="2" FACE="굴림체">
사전 도움말 - 이용약관 - 개인정보취급방침 - 책임의 한계와 법적고지 - 고객센터<BR> 
Copyright ⓒ 2019 SSAFY. All Rights Reserved.
</FONT>
</CENTER>
</body>
</html>