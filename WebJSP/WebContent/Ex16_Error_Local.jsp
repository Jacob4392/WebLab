<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/error/commonerror.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	페이지마다 고유하고 : page errorPage="" 설정페이지
	
	개발시: x
	최종배포시: 설정
	
	모든 페이지마다 예외에 대한 대체 page를 넣고 싶다>> 전역 >> web.xml >> 자동으로 모든페이지의 설정이 걸림 
 -->
<%
	String data = request.getParameter("name").toLowerCase();
%>
<%= data %>
</body>
</html>