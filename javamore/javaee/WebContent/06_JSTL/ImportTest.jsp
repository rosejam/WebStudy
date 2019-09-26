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

<br/><br/><br/><br/><br/>
<!-- include는 context 내의 페이지만 include한다
	 그러나 jstl의 import는 다른 context 다른 server의 페이지도 include한다. 
 -->
<c:set var='url' value='https://www.naver.com'/>
<c:import url="${url }"/>
</body>
</html>