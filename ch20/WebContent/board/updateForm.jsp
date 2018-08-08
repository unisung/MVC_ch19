<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function chk(){
 var pass1 = document.getElementById("pass1");
 var pass2 = document.getElementById("pass2");
 if(pass1.value!=pass2.value){
	 alert('비밀번호와 확인번호가 다릅니다.');
	 pass1.value="";
	 pass2.value="";
	 pass1.focus();
	 return false;
 }
 return true;
}

</script>
</head>
<body>
${msg}
<center><h3>수정 폼</h3></center>
<form action="updatePro.do" method="post" onsubmit="return chk()">
 <table border=1 cellspacing="0">
 <input type="hidden" name="no" value=${board.no}>
 <tr>
 <th>글쓴이</th>
 <td><input type="text" name="name" value=${board.name}>
 </tr>
 <tr>
 <th>제목</th>
 <td>
 <input type="text" name="title" value="${board.title}">
 </td>
 </tr>
 <tr>
 <th>글 내용</th>
 <td>
 <textarea rows="10" cols="50" name="content">${board.content}</textarea>
 </td>
 </tr>
 <tr>
 <th>비밀번호</th>
 <td>
 <input type="password" name="password" id="pass1">
 </td>
 </tr>
<tr>
 <th>비밀번호 확인</th>
 <td>
 <input type="password" name="password2" id="pass2">
 </td>
 </tr>
 <tr>
 <td colspan=2 align="center">
 <input type="submit" value="입력">
 <input type="reset" value="취소">
 <input type="button" value="리스트로" onclick="location.href='List.do'">
 </td>
 </tr>
 </table>
</form>
</body>
</html>