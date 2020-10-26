<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//EL script 언어 : 서버쪽 자원을 접근, 출력할 수 있습니다 -> <%= 이 없이 쓸수 있습니다.
	//EL 사용한다고 해서 JAVA 객체 API까지 지원하지는 않습니다
	Date today = new Date();
	request.setAttribute("day", today);
	session.setAttribute("day2", today);
	//이 담아놓은 데이터를 화면에 출력할 때 EL을 사용합니다.
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL의 목적은 화면에 출력하는 것</h3>
	EL(객체명 명시) : ${requestScope.day}<br>
	EL : ${day}<br> <!-- 이렇게도 가능하나 request인지 session인지 확실하지 않기 때문에 명시하도록 하기 -->
	session EL: ${sessionScope.day2}<br>
	
	<!-- EL의 단점 : 출력은 되나 제어(조건문 등)가 안됨 -->
	<!-- EL & JSTL 서버쪽의 자원을 사용하지 않고도 서버쪽 데이터를 이용할 수 있다 -->
	
</body>
</html>