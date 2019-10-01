<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#addFile").click(addFileForm);
});
var count=0;   //file form index
var fileCount=0;
var fileName=new Array();
function addFileForm(){
	var html="<div id='item_"+count+"'>"
	html+="<input type='file' name='fileup"+count+"' />";
	html+="<input type='button' value='삭제' onclick='removeForm("+count+")'/></div>"
	fileName.push('fileup'+count);
	count++;
	fileCount++;
	//html=$("#content").html()+html;
	//$("#content").html(html);
	$("#fileUpForm").append(html);
	console.log(fileName.toString());
	$('#fileCount').val(fileCount);
	$('#fileName').val(fileName.toString());
}
function removeForm(count){
	var item = document.getElementById('item_'+count);
	if(item !=null) item.parentNode.removeChild(item);
	index = fileName.indexOf('fileup'+count);
	delete fileName[fileName.indexOf('fileup'+count)];
	fileCount--;
	$('#fileCount').val(fileCount);
	$('#fileName').val(fileName.toString());
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
		<form method="post" action="insertBoard.do" >
			<input type="hidden"  name="fileCount" id="fileCount" value="0"/>
			<input type="hidden"  name="fileName" id="fileName" value=""/>
			<table align="center" width="300">
			<tr><th colspan="2"> 게시글 작성 </th></tr>
			<tr height="30" width="100"><td><label for="title">제목</label></td>
			    <td><input type="text" name="title" id="title"/></td>
			</tr>
			<tr height="30"><td><label for="title">아이디</label></td>
			    <td>${id}</td>
			</tr>
			<tr height="30" ><td><label for="fileup">업로드할 파일</label></td>
			    <td>
			    	<input type="button" name="addFile" id="addFile" value="파일 추가"/>
			    </td>
			</tr>
			<tr height="30" ><td colspan="2" id="fileUpForm"> </td>
			</tr>
			<tr><td colspan="2"><label for="content">내용</label></td></tr>
			<tr><td colspan="2" align="center">
			    <textarea name="contents" id="contents" cols="50" rows="7"></textarea>
			</td></tr>
			<tr><td colspan="2" align="center">
				<input type="submit" value="작성"/>
				<input type="reset" value="취소"/>
			</td></tr>
	</table>
	</form>
	</article>
</article>		
<footer id="copyright">
<jsp:include page="/copyright.jsp"/>
</footer>	
</body>
</html>

