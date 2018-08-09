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
 var frm = document.getElementById('frm');
 frm.action='List.do';
 frm.submit();
}
</script>
</head>
<body>
${msg}<br>
<form action="" name="frm" id="frm">
<select name="searchOption">
<option value="sel" disabled="disabled">선택</option>
<option value="title">title</option>
<option value="content">content</option>
</select>
<input type="text" name="searchCont">
<input type="button" value="검색" onclick="chk()">
</form>
<br>
<a href="writeForm.do">글쓰기</a><br>
<c:if test="${list.total==0}">
<h3>게시판 내용이 없습니다.</h3>
</c:if>
<c:if test="${list.total>0}">
<table>
<tr>
<th><b>번호</b></th><th><b>작성자</b></th><th><b>제목</b></th>
</tr>
<c:forEach var="b" items="${list.board}" >
<tr>
<td><a href="Content.do?no=${b.no}">${b.no}</a></td>
<td>${b.name}</td>
<td><a href="Content.do?no=${b.no}">${b.title}</a></td>
</tr>
</c:forEach>
</table>
  <c:if test="${list.startPage > 5}">
  <a href="List.do?pageNum=${list.startPage-5}">[이전]</a>
</c:if>
<c:forEach var="pNo" begin="${list.startPage}" end="${list.endPage}">
 <a href="List.do?pageNum=${pNo}">[${pNo}]</a>
</c:forEach>
 <c:if test="${list.endPage < list.totalPages}">
 	<a href="List.do?pageNum=${list.startPage+5}">[다음]</a>
 </c:if>
</c:if>
</body>
</html>