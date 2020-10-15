<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//http://localhost:8090/WebClient_javascript/Ex08_login.jsp?txtuserid=kglim&txtpwd=1004
	//서버에 받기
	String id = request.getParameter("txtuserid");
	String pwd = request.getParameter("txtpwd");
	//검증하거나 DB작업을 하거나...
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버 전송 완료 DB확인 ^^<br>
<%= id %><hr>
<%= pwd %>

</body>
</html>