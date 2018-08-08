<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html><head>
<title>내용 보기</title>
</head>
<body>
<c:if test="${empty board}">
<h3>내용이 없습니다.</h3>
</c:if>
<c:if test="${not empty board}">
<center><h3>게시글 내용 보기</h3></center>
<table border=1 cellspacing="0">
<input type="hidden" name="no" value="${board.no}">
 <tr>
 <th>글쓴이</th>
 <td><input type="text" name="name" value="${board.name}">
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
 <td colspan=2 align="center">
 <input type="button" value="리스트" onclick="location.href='List.do'">
 <input type="button" value="수정" 
                    onclick="location.href='updateForm.do?no=${board.no}'">
 <input type="button" value="삭제" 
                    onclick="location.href='deleteForm.do?no=${board.no}'">
 </td>
 </tr>
 </table>
</c:if>
</body>
</html>