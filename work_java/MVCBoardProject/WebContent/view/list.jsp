<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ //본문 미리보기를 ajax로 구현할 것
		$('.title').mouseover(function(){ //'tr'이면 행에 마우스 올릴 경우 '.title'이면 제목에 마우스 올릴 경우
			var number = $(this).attr('id'); //마우스가 올라간 이 span의 id속성의 값(=글번호)을 알아옴!
			//alert(number);
			//ajax요청 보내기
			$.ajax({//"json형식으로" ajax통신에 필요한 정보 언급해 줘야 됨
				url:'read2.bod', //serer 주소
				data:{
					num: number //서버로 보낼 데이터(글번호 number, , ..)
				},
				success: function(result, status, xhr){ //서버로부터 데이터 전송이 성공적이면
														//	(서버에서 응답이 성공적으로 도착했을 때) 작동할 함수 -> Callback method
					$('#display').html('<h3>'+result+'</h3>');//div에 표시할땐 html()사용!! 아닐경우 val() 
																//result는 성공적으로 받아온 데이터
					$('#display').css('visibility','visible');
				}
			});			
		});
	});
</script>
</head>
<body>
<center>
		<h1>JSP 게시판</h1>			
		<form method="post" action="search.bod">
			<select name="condition">
				<option value="name">글쓴이</option>
				<option value="title">제  목</option>
			</select>
			<input type="text" name="word">
			<input type="submit" value="검색">
		</form>
		
		<div id="display" style="visibility:hidden;"><h3>aaa</h3></div> <%-- visibility로 해서 자리차지를 하고있다(display는 차지도 안함) --%>
		
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING = 1><TR>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>번호</th>
		<th width=200 bgcolor=#113366><font color=#ffffee size=2>제목</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>글쓴이</th>
		<th width=150 bgcolor=#113366><font color=#ffffee size=2>날짜</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>조회수</th>

		<c:forEach items="${list }" var="c">
	    <tr bgcolor=pink>
		  <td align=center bgcolor=pink>&nbsp;<font size=2>${c.num }</td>
	       
	      <td align=center bgcolor=pink>&nbsp;<font size=2>
			<span id="${c.num }" class="title"> <%-- ajax용 --%>
	      		<a href="read.bod?num=${c.num }">${c.title }</a>
	       	</span>	     
	      </td>
	      <td align=center bgcolor=pink>&nbsp;<font size=2>${c.name }</td>
	       
	      <td align=center bgcolor=pink>&nbsp;<font size=2>${c.wdate }</td>
	       
	      <td align=center bgcolor=pink>&nbsp;<font size=2>${c.count }</td>	       
	    </tr>
	   </c:forEach>
</table>
<br></br>
<a href=insertForm.bod>새글쓰기</a>
</body></html>