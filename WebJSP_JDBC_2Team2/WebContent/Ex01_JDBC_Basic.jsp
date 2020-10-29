<%@page import="kr.or.bit.dto.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bit.dao.EmpDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	// DB와 질의하기 위해 DAO객체 생성 & 결과 출력은 List<EmpDTO>타입
	EmpDAO emp = new EmpDAO();
	List<EmpDTO> emplist = new ArrayList<EmpDTO>();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		table{border: 1px solid black; border-collapse: collapse;}
		tr{border: 1px solid blue; background-color: white; color: black}
		td{border: 1px solid red;}
	</style>
</head>
<body>
<!--  
	JDBC
	1. 드라이버 참조 (WEB > Webcontent > WEB-INF > lib > 붙여넣기 (ojdbc6.jar)
	2. 드라이버 메모리 로딩 : class.forName("드라이버 클래스명")
	3. DB 연결(연결문자열 : 서버 IP, PORT , 계정 , 비번 )
	
	JAVA JDBC API(Interface , class 제공)
	Connection
	Statement
	PrepareStatement
	ResultSet
-->
<table border="1">
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>직종</th>
		<th>매니저</th>
		<th>고용일자</th>
		<th>급여</th>
		<th>인센티브</th>
		<th>부서번호</th>
	</tr>
	<c:forEach var="column" items="<%=emp.getEmpDAOAllList()%>">
		<tr>
			<td>${column.empno}</td>
			<td>${column.ename}</td>
			<td>${column.job}</td>
			<td>${column.mgr}</td>
			<td>${column.hiredate}</td>
			<td>${column.sal}</td>
			<td>${column.comm}</td>
			<td>${column.deptno}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>









