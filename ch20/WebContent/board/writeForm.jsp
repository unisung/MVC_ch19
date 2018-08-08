<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="writePro.do" method="post">
 <table border=1 cellspacing="0">
 <tr>
 <th>글쓴이</th>
 <td><input type="text" name="name">
 </tr>
 <tr>
 <th>제목</th>
 <td>
 <input type="text" name="title">
 </td>
 </tr>
 <tr>
 <th>글 내용</th>
 <td>
 <textarea rows="10" cols="50" name="content"></textarea>
 </td>
 </tr>
 <tr>
 <th>비밀번호</th>
 <td>
 <input type="password" name="password">
 </td>
 </tr>
<tr>
 <th>비밀번호 확인</th>
 <td>
 <input type="password" name="password2">
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