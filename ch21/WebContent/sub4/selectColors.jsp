<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>색상을 선택하세요</h3>
<form action="colors.jsp">
  <label>red
  <input type="checkbox" name="color" value="red"></label><br>
  <label>white
  <input type="checkbox" name="color" value="white"></label><br>
  <label>Blue
  <input type="checkbox" name="color" value="blue"></label><br>
  <label>yellow
  <input type="checkbox" name="color" value="yellow"></label><br>
  <label>green
  <input type="checkbox" name="color" value="green"></label><br>
  
  <input type="submit" value="전송">
</form>

</body>
</html>