<%@page import="kr.or.bit.Emp"%>
<%@page import="java.time.Year"%>
<%@page import="java.util.Calendar"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Emp e = new Emp();
	e.setEmpno(1000);
	e.setEname("홍길동");
	
	//Calendar 객체 생성하고
	//화면에 년 월 일 정보를 출력하세요
	
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
출력(표현식)<br>
<%= e.getEmpno() %><br>
<%= e.getEname() %><br>
<%= e.toString() %><hr>

현재: <%= year %>년<%= month %>월<%= date %>일<br>
</body>
</html>