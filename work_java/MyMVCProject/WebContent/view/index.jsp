<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}
a {
	margin: 10px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#q1').click(function(){
			var num1 = $('#num1').val();
			var num2 = $('#num2').val();
			//ajax요청 보내기
			$.ajax({//json형식으로 ajax통신에 필요한 정보 언급해 줘야 됨
				url:'main.do?action=q1', //get방식으로 보내준다!!!!
				data:{
					 num1: num1 //서버로 보낼 데이터(글번호 number, , ..)
					,num2: num2
				},
				success: function(result, status, xhr){ //서버로부터 데이터 전송이 성공적이면
					$('#display').html('<h3>'+result+'</h3>');//div에 표시할땐 html()사용!! 아닐경우 val()
				}
			});			
		});
		$('#q2').click(function(){
			//alert("dd");
			var num3 = $('#num3').val();
			var num4 = $('#num4').val();
			//ajax요청 보내기
			$.ajax({//json형식으로 ajax통신에 필요한 정보 언급해 줘야 됨
				url:'main.do?action=q2', //serer 주소
				data:{
					 num3: num3
					,num4: num4
				},
				success: function(result, status, xhr){ //서버로부터 데이터 전송이 성공적이면
					$('#display').html('<h3>'+result+'</h3>');//div에 표시할땐 html()사용!! 아닐경우 val()
					//$('#display').css('visibility','visible');
				}
			});			
		});
	});
	
</script>
</head>
<body>
<h1> 메인 페이지 </h1>
<p/>

num1:	<input type="text" name="num1" id="num1">
num2:	<input type="text" name="num2" id="num2">
<button id="q1">get-1</button> 
<hr>
num3:	<input type="text" name="num3" id="num3">
num4:	<input type="text" name="num4" id="num4">
<button id="q2">get-2</button> 
<div id="display"></div>

</body>
</html>