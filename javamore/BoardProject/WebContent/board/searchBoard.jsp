<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<script type="text/javascript">
	function updateForm(){
		var frm = document.getElementById("frm");
		frm.action="updateBoardForm.do";
		frm.submit();
	}
	function deleteBoard(){
		var frm = document.getElementById("frm");
		frm.action="deleteBoard.do";
		frm.submit();
	}
	function listBoard(){
		location.href="listBoard.do?${pageContext.request.queryString}";
	}
	function resetBoard(){
		var frm = document.getElementById("updatefrm");
		frm.title.value="";
		frm.content.value="";
	}
</script>
</head>
<body>
<div id="head">
	 <jsp:include page="/menu.jsp"/>
</div>
<article id="content"> 
	<jsp:include page="/aside.jsp"/>
	<article  id="mainContent">
		<div class="main" id="viewBoard">
	 	<form id="frm"  >
	 	    <input type ="hidden" name="no"  id="no"  value='${board.no }'/>
	 	    <input type ="hidden" name="query"  id="query" />
			<table border="1" align="center"  width='400'>
				<tbody>
					<tr><td width='100'><label for="title">제목</label></td>
					    <td>${board.title}</td>
					</tr>
					<tr><td colspan="2">내용 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															글쓴이:${board.id}
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
															게시일:${board.regdate}</td></tr>
					<tr><td colspan="2"  valign="top" height="200">
						<pre>${board.contents}</pre>							
						</td></tr>
				</tbody>
				<tfoot>
					<tr><td colspan="2" align="center">
						<a href="#" onclick="listBoard('frm')">목록</a>
						
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	</article>
</article>		
<footer id="copyright">
<jsp:include page="/copyright.jsp"/>
</footer>	
</body>
</html>


   	