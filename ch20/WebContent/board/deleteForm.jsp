<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body <%-- onload ="chk(${no})" --%>>
<h4>${msg}</h4>
<form action="deletePro.do">
게시글 번호 <input type="text" name="no" value="${no}" size="5" readonly> 을 삭제하시겠습니까?<br>
<input type="submit" value="확인">
<input type="button" value="취소" onclick="location.href='List.do'">
</form>
</body>
</html>