<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 outer 파일입니다.</h1>
	<%-- 지시어로 include하는 경우 : outer.jsp파일 안에 inner.jsp"파일 전체 내용이 copy&paste 효과"
	inner.jsp 파일의 내용이 자주 바뀌면 outer.jsp의 내용도 계속 변경되어야 함(inner가 "바뀔 때 다시 복붙") --%>
	<%@ include file="inner.jsp" %>
	<h1>여기도 outer 파일입니다.</h1>
	<%@ include file="inner.jsp" %>
	
	<%-- action 원소로 include 하는 경우: 메소드 호출과 비슷. 
	"include 문장을 만나는 순간" inner2.jsp 파일이 내용을 가져다가 outer.jsp파일 안에 포함시켜 출력. inner.jsp 파일의 내용이 자주 바뀌어도
	outer.jsp의 내용은 변경되지 않음 --%>
	<jsp:include page="inner2.jsp"></jsp:include>
</body>
</html>