<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String color[] = request.getParameterValues("color");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>색고르기</title>
</head>
<body>
   <h4>선택하신 색은 다음과 같습니다.</h4>
   <%
   	if(color!=null){
   		for(int i=0;i<color.length;i++)
   			out.print(color[i]+"<br>");
   	}
   
   %>
</body>
</html>