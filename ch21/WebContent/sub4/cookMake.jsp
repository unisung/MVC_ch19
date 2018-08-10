<%@page import="java.net.URLEncoder"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.output.Encoded"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String id=URLEncoder.encode("Cookie 빨강","utf-8");
	
	Cookie cook = new Cookie("id",id);
	response.addCookie(cook);
%>
쿠키저장 성공<p>
<a href="cookUse.jsp">쿠키보기</a>
</body>
</html>