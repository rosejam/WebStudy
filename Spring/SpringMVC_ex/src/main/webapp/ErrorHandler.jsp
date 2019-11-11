<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" /> 
</head>
<body>
<div id="head">
   <article id="logo"><img src="images/nciaedu_logo.png"/></article>
   <nav id="private">
   	<ul>
		<c:choose>
		   <c:when test="${empty id}">
			<li><a href="loginform.do">로그인</a></li>
		   </c:when>
		   <c:otherwise>
		     <li><a href="logout.do">로그아웃</a></li>
		     <li><a href="memberUpdateForm.do">회원정보수정</a></li>
		     <li><a href="myPage.do">myPage</a></li>
		   </c:otherwise>
		</c:choose>
	</ul>
	</nav>
</div>
<article id="content"> 
	<aside>
		<nav id="menu">		
		 <a href="insertMemberForm.do">회원가입</a><br/>
		 <a href="listBoard.do">게시판</a>
		</nav>
	</aside>
	<article  id="mainContent">
		<table align="center">
			<caption> 에러 발생 </caption>
			<tr><td> ${msg} </td></tr>
			<tr><td> 에러가 발생했습니다. 다시 수행해 주세요! </td> 
		</table>
	</article>
</article>		
<footer id="copyright">

</footer>	
</body>
</html>





	





