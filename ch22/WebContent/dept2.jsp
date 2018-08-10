<%@page import="java.util.List"%>
<%@page import="dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%
     EmpDao dao = EmpDao.getInstance();
	 List<String> deptList = dao.deptList();
	 
	 request.setAttribute("list", deptList);
%>
<html><head><title>Insert title here</title></head>
<body>
<h2>직원 정보</h2>
<form action="Json2">
 부서:<select name="no">
     <option value="선택" disabled="disabled">선택</option>
     <c:if test="${not empty list}">
     <c:forEach var="j" items="${list}">
      <option value="${fn:substring(j,0,2)}">${j}</option>
     </c:forEach>
     </c:if>
 </select>
 <input type="submit" value="전송">
</form>
</body>
</html>