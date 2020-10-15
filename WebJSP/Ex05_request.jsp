<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	//1. request 객체 (클라이언트 입력값)
	//[단일값]
	//input type > text, password, radio ,textarea , select(단일) 
	//[복수값]
	//input type > checkbox (name 이 같은경우) ,select (mutiple 속성)		
	String uid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");

	String[] hobby = request.getParameterValues("hobby");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>