<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DAO.EmpDao"%>
<%@page import="DTO.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%
	EmpDao dao = new EmpDao(); 
	List<Emp> emplist = dao.getEmpAllList();
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Emp Table</h3>
	<table border="1">
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>직책</th>
			<th>사수번호</th>
			<th>고용번호</th>
			<th>급여</th>
			<th>보너스</th>
			<th>부서번호</th>
		</tr>
		
		<%-- <c:set var="emplist" value="<%=emplist %>"/> --%>
		<c:forEach var="emp" items="<%=emplist %>">
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.getJob()}</td>
			<td>${emp.getMgr()}</td>
			<td>${emp.getHiredate()}</td>
			<td>${emp.getSal()}</td>
			<td>${emp.getComm()}</td>
			<td>${emp.getDeptno()}</td>
		</tr>
		</c:forEach>

	</table>


</body>
</html>