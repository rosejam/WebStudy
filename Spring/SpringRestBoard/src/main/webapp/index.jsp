<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		boardList(); //모든 고객 데이터 요청해서 화면에 뿌림
		boardSelect(); //고객 한 사람 정보 요청시 처리할 이벤트 등록
		boardUpdate();
		boardDelete(); //삭제 요청시 처리할 이벤트 등록
		boardInsert(); //새고객 등록 요청시 처리할 이벤트 등록
		init(); //글자 지워주는 메서드
		
	});
	
	//모든 사용자 목록 조회 요청
	function boardList() {
		//rest서버에 ajax로 데이터 요청(형식은 json)
		$.ajax({
			url:"boards", //서버에 보낼 요청 uri(앞에 /붙이면 안됌)
			method:"get",
			dataType:'json', //서버에서 오는 "응답" 데이터 타입
			success: function(data){ //서버로 부터 데이터가 잘 도착했을 경우 실행되는 callback function
										//data : 서버가 보내준 결과값
				boardListResult(data);
			},
			error: function(xhr, status, msg){ //(xhr객체, 상태, 서버에서 보내준 메시지)
				alert("상태값:" + status + " http 에러메세지:" + msg);
			}
		});//ajax
	}//boardList
	function boardListResult(data){
		$("tbody").empty(); //테이블 몸체 안의 기존 내용 삭제
		
		$.each(data, function(idx, item){ //data에서 한개씩 꺼낸 json 객체인 item : [{num:111, name:'dada', address:'la'}]와 같은 형식!!!
 			$("<tr>")
				.append($("<td>").html(item.num)) //111
				.append($("<td>").html(item.name)) //dada
				.append($("<td>").html(item.wdate)) //la
				.append($("<td>").html(item.title)) //la
				.append($("<td>").html(item.count)) //la
				.append($("<td>").html("<button id='btnSelect'>조회</button>")) //조회버튼 생성
				.append($("<td>").html("<button id='btnDelete'>삭제</button>")) //삭제버튼 생성
				.append($("<input type='hidden' id='hidden_num'>").val(item.num))
				.appendTo("tbody"); //지금 까지 내용이 tbody에 가서 붙는다.
		}); //each
		
	}
	
	//사용자 조회 요청 이벤트 등록
	function boardSelect() {
		//이벤트 등록
		$('body').on('click', '#btnSelect', function(){ //(이벤트, "body자식 중 나중에 생성된 것들"을 대상으로 함 - 페이지 로딩시에는 없었음, 이벤트핸들러)
			var num = $(this).closest('tr').find('#hidden_num').val(); //클릭된 행의 히든값인 item.num을 가져오게 된다.
			
			//특정 사용자 정보 ajax 요청
			$.ajax({
				url:"boards/" + num, //서버에 보낼 요청 uri
				method:"get",
				dataType:'json', //서버에서 오는 "응답" 데이터 타입
				success: function(data){ //서버로 부터 데이터가 잘 도착했을 경우 실행되는 callback function
											//data : 서버가 보내준 결과값
					boardSelectResult(data);
					boardList(data); //조회 후, 바로 리스트를 다시 부른다!!(조회수 오르는거 보여주기 위해)
				},
				error: function(xhr, status, msg){ //(xhr객체, 상태, 서버에서 보내준 메시지)
					alert("상태값:" + status + " http 에러메세지:" + msg);
				}
			});//ajax
			
		});
	}//boardSelect
	function boardSelectResult(data) {
		//입력칸에 data 넣어주기 (data가 1개 이므로 item을 하나하나 꺼낼 필요가 없음)
		$('#num').val(data.num);
		$('#name').val(data.name);
		//$('#wdate').val(data.wdate);
		$('#title').val(data.title);
		$('#content').val(data.content);
		//$('#count').val(data.count);
		
	}
	
	//사용자 삭제 요청 이벤트 등록
	function boardDelete() {
		//이벤트 등록 //파라메터 3개짜리 .on()으로!
		$('body').on('click', '#btnDelete', function(){ //(이벤트, "body자식 중 나중에 생성된 것들"을 대상으로 함 - 페이지 로딩시에는 없었음, 이벤트핸들러)
			var num = $(this).closest('tr').find('#hidden_num').val(); //클릭된 행의 히든값인 item.num을 가져오게 된다.
			
			//특정 사용자 삭제 ajax 요청
			$.ajax({
				url:"boards/" + num, //서버에 보낼 요청 uri
				method:"delete",
				dataType:'json', //서버에서 오는 "응답" 데이터 타입
				success: function(data){
					boardList(data); //삭제 후, 바로 리스트를 다시 부른다!!
				},
				error: function(xhr, status, msg){ //(xhr객체, 상태, 서버에서 보내준 메시지)
					alert("상태값:" + status + " http 에러메세지:" + msg);
				}
			});//ajax
			
		});
	}//boardDelete
	
	//사용자 등록 요청 이벤트 등록
	function boardInsert() {
		$('#btnInsert').on("click", function(){ //페이지 로딩때 부터 있는 버튼이므로 파라메터 2개짜리 .on()
			//사용자가 입력한 값 받아오기
			var pass = $("#pass").val();
			var name = $("#name").val();
			var title = $("#title").val();
			var content = $("#content").val();
			
			//사용자 등록 ajax 요청(json 형식으로 )
			$.ajax({
				url:"boards",
				method:"post",
				dataType:'json', //서버에서 오는 응답 데이터 타입!
				data: JSON.stringify({ //json 객체를 json 형식의 문자열로 바꿔줌!!!
					pass:pass,
					name:name,
					title:title,
					content:content
				}),
				contentType:"application/json", //서버로 보낼 "요청" 데이터 타입 지정!!
				success: function(data){ //callback function
					boardList(data); //리스트를 다시 부른다
					//init해서 빈칸으로 만들어줌
					$('#num').val('');
					$('#pass').val('');
					$('#name').val('');
					$('#title').val('');
					$('#content').val('');
				},
				error: function(xhr, status, msg){
					alert("상태값:" + status + " http 에러메세지:" + msg);
				}
			});
		});
		
	}//boardInsert
	
	//사용자 수정 요청 이벤트 등록
	function boardUpdate() {
		$('#btnUpdate').on("click", function(){ //페이지 로딩때 부터 있는 버튼이므로 파라메터 2개짜리 .on()
			//사용자가 입력한 값 받아오기
			var num = $("#num").val();
			var pass = $("#pass").val();
			var name = $("#name").val();
			var title = $("#title").val();
			var content = $("#content").val();
			
			//사용자 등록 ajax 요청(json 형식으로 )
			$.ajax({
				url:"boards",
				method:"put",
				dataType:'json', //서버에서 오는 응답 데이터 타입!
				data: JSON.stringify({ //json 객체를 json 형식의 문자열로 바꿔줌!!!
					num:num,
					pass:pass,
					name:name,
					title:title,
					content:content
				}),
				contentType:"application/json", //서버로 보낼 "요청" 데이터 타입 지정!!
				success: function(data){ //callback function
					boardList(data); //리스트를 다시 부른다
					//init해서 빈칸으로 만들어줌
					$('#num').val('');
					$('#pass').val('');
					$('#name').val('');
					$('#title').val('');
					$('#content').val('');
				},
				error: function(xhr, status, msg){
					alert("상태값:" + status + " http 에러메세지:" + msg);
				}
			});
		});
		
	}//boardUpdate
	
	function init() {
		//초기화 버튼 클릭
		$('#btnInit').on('click', function() { //id가 btnInit인 것의 이벤트핸들러
			$('#form1').each(function() {
				this.reset();
			});
		});
	}//init
</script>
</head>
<body>
	<div class="container">
		<form id="form1" class="form-horizontal">
			<h2>게시글 등록 및 수정</h2>
			<div class="form-group">
				<label>번호:</label> <input type="text" class="form-control" name="num" 	id="num">
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" class="form-control" name="name" 	id="name">
			</div>
			<div class="form-group">
				<label>비밀번호:</label> <input type="text" class="form-control"	name="pass" id="pass">
			</div>
			<div class="form-group">
				<label>제목:</label> <input type="text" class="form-control"	name="title" id="title">
			</div>
			<div class="form-group">
				<label>내용:</label> <input type="text" class="form-control"	name="content" id="content">
			</div>

			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="등록" id="btnInsert" /> 
				<input type="button" class="btn btn-primary" value="수정" id="btnUpdate" /> 
				<input type="button" class="btn btn-primary" value="초기화" id="btnInit" />
			</div>
		</form>
	</div>
	<hr />
	<div class="container">
		<h2>게시판 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center">이름</th>
					<th class="text-center">작성일</th>
					<th class="text-center">제목</th>
					<th class="text-center">조회수</th>
				</tr>
			</thead>
			<tbody>
			<!-- 여기에 data가 들어감 -->
			</tbody>
		</table>
	</div>
</body>
</html>