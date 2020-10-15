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
	정보(데이터) > 어디에 저장할까?
	
	클라이언트(개인 로컬 PC) : 웹서버(웹서버 또는 DB서버)
	
	정보(데이터) >> 어디에 저장
	대답) 보안(정보의 중요성), 소멸(일시적, 영속적)
	
	Client (Local PC: 웹브라우저)
	1. Cookie (메모리쿠리 : 브라우저가 켜져있을 때만 사용되는 쿠키
				파일쿠키(local PC에 txt파일로 저장 >> 자동으로 암호화 >>소멸시기가 있음))
	2. Local Storage (map (key:value))
	
	Server (Web Server: Apache Tomcat)
	1. server memory : session 객체 (접속한 사용자 식별값, 개인정보) >> 서버 리부팅, 꺼지거나
	2. server memory : Application 객체 (접속한 사용자의 공유자원, 개인정보) >> 서버 리부팅, 꺼지거나
	3. server 영속적: login.txt >> 관리가 힘들어요
	4. DB server: 보안, 관리, 영속적			
				
 -->
<%
	Cookie mycookie = new Cookie("cname", "1004");
	//생성
	
	//Client 브라우저 전달 >> response
	response.addCookie(mycookie);
%>
<a href="Ex17_Cookie_Read.jsp">Cookie read</a><br>
</body>
</html>