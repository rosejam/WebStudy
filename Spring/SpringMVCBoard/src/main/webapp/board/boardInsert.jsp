<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form method="post" action="boardInsert.do" enctype="multipart/form-data">
	<table>
		
		<tbody>
			<tr height="50"><td><label for="title">제목</label></td>
			    <td><input type="text" name="title" id="title"/></td>
			</tr>
			<tr height="50"><td><label for="pass">비밀번호</label></td>
			    <td><input type="text" name="pass" id="pass"/></td>
			</tr>
			<tr height="50"><td><label for="title">이름</label></td>
			    <td><input type="text" name="name" id="name"/></td>
			</tr>			
			<tr><td colspan="2"><label for="content">내용</label></td></tr>
			<tr><td colspan="2" align="center">
			    <textarea name="contents" id="content" cols="30" rows="10"></textarea>
			</td></tr>
		</tbody>
		<tfoot>
			<tr><td colspan="2" align="center">
				<input type="submit" value="작성"/>
				<input type="reset" value="취소"/>
			</td></tr>
		</tfoot>
	</table>
</form>
</body>
</html>