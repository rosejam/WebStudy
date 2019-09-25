<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
<link href="css/basic.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
	Member member=(Member)request.getAttribute("member");
	
	if(msg !=null){
%>
    <%=msg%>
  <%}else{ %>
<form method="post" action='main.do'>
<input type="hidden" name="action" value="memberUpdate.do"/>
<table align='center' >
	<tr><td class="caption" colspan='2'>회원정보</td></tr>
	<tr><td class='tbasic'>아이디</td>
	    <td class='tbasic'>
	    <input type='text' name='id'  id='id' value='${member.id }'></td>
	</tr>
	<tr><td class='tbasic'>비밀번호</td>
	    <td class='tbasic'>
	    <input type='password' name='pw'  id='pw'  value='${member.pw }'></td>
	</tr>
	<tr><td class='tbasic'>이름</td>
	    <td class='tbasic'>
	    <input type='text' name='name'  id='name'   value='${member.name }'></td>
	</tr>
	<tr><td class='tbasic'>이메일</td>
	    <td class='tbasic'>
	    <input type='text' name='email'  id='email' value='${member.email }'>
	</tr>
	<tr><td class='tbasic'>전화번호</td>
	    <td class='tbasic'>
	    <input type='text' name='phone'  id='phone'  value='${member.phone }'>
	</tr>
	<tr><td class='tbasic'>주소</td>
	    <td class='tbasic'>
	    <input type='text' name='address'  id='address' value='${member.address }'>
	</tr>
	<tr>
	   <td colspan='2' align='center' class='tfoot tspacial'>
	     <input type="submit" value='수정'>
		 <input type="reset" value='취소'>
	   </td>
	</tr>
</table>
</form>
<%}%>
</body>
</html>