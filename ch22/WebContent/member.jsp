<%@page import="java.util.List"%>
<%@page import="dao.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
     EmpDao dao = EmpDao.getInstance();
	 List<String> jobList = dao.jobList();
	 
	 request.setAttribute("list", jobList);
%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>직원 정보</h2>
<form action="MemberInfoXml2">
 업무:<select name="job">
     <option value="선택" disabled="disabled">선택</option>
     <c:if test="${not empty list}">
     <c:forEach var="j" items="${list}">
      <option value="${j}">${j}</option>
     </c:forEach>
     </c:if>
 </select>
 <input type="submit" value="전송">
</form>
</body>
</html>