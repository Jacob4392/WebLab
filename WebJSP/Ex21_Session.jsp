<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	session 객체: 접속한 사용자(브라우저, 클라이언트) 마다 서버에서 부여하는 고유한 객체
	
	session 값: 웹 서버가 접속한 클라이언트에게 부여하는 고유한 식별값(ID값)
	
	A 사용자: 웹서버에 접속: session 객체 생성: 고유한 ID값 부여 >> 그 ID값을 클라이언트에게 response합니다
	B 사용자: 웹서버에 접속: session 객체 생성: 고유한 ID값 부여 >> 그 ID값을 클라이언트에게 response합니다
	response 한것은 쿠키가 관리합니다.
	 
	JSESSIONID : A3D3E3315CEAB4889AB550F4EAE0A7FD >>유일값 (접속한 사용자에게 주는 고유한 객체)
	
	session 객체:
	1. 로그인 ID 정보, 쇼핑몰 구매한 물건 정보, 접속시간 관리... 개인별 정보를 담는다
 -->

 <%
 	Date time = new Date();
 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 %>
 <h3>세션정보</h3>
 	session 객체의 식별값 <%= session.getId() %><br>
<%
	time.setTime(session.getCreationTime());
	
%> 	
[session 생성된 시간]: <%= formatter.format(time) %>
<hr>
<%
	time.setTime(session.getLastAccessedTime());
%>
[session 마지막 접속시간(client)]: <%= formatter.format(time) %>
 	
</body>


</html>