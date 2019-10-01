<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" /> 
</head>
<body>
<div id="head">
   <jsp:include page="/menu.jsp"/>
</div>
<article id="content"> 
	<jsp:include page="/aside.jsp"/>
	<article  id="mainContent">
	<c:choose>
		<c:when  test="${!empty content}">
			<jsp:include page="${content}"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="main.jsp"/>
		</c:otherwise>
	</c:choose>
	</article>
</article>		
<footer >
<jsp:include page="copyright.jsp"/>
</footer>	
</body>
</html>




