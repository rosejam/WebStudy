<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<c:url var="ctx" value="../"/>

	<c:choose>
		<c:when test="${param.user == 'member' }">
			<jsp:include page="${ctx }Login.jsp"/>
		</c:when>
		<c:when test="${param.user == 'guest' }">
			<jsp:include page="${ctx }memberRegister.html"/>
		</c:when>
		<c:otherwise>
			<p>잘못 입력했습니다</p><!-- if else문의 else -->
		</c:otherwise>
	</c:choose>
<br/><a href="ChooseTest.html">다시입력</a>

</body>
</html>








