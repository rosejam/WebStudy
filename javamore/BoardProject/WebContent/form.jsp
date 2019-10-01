<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
	<article  id="mainContent">
		
	</article>
</article>		
<footer id="copyright">
<jsp:include page="/copyright.jsp"/>
</footer>	
</body>
</html>




