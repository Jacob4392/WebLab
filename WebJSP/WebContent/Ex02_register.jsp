<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	//1. 클라이언트가 전송한 데이터 받기
	//Tomcat: 웹에서 사용할 수 있는 전용 객체를 제공(request, response 객체):WAS >> 내장객체
		//new 안해도 쓸수 있도록 미리 만들어 놓았음
	//request 요청객체 (클라이언트 정보 얻는다: 전송한 내역이 request에 담긴다)
	//클라이언트 IP, 브라우저 종료, 입력한 데이터 
	
	//response 응답객체(서버 -> 클라이언트 전달하는 방법)
	String uid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	//String hobby1 = request.getParameter("hobby");

	//다중의 값을 전달할 때
	String[] hobbys = request.getParameterValues("hobby");
	
	/*
	한글처리(GET)(Tomcat9 버전(한글 출력))
	**Tomcat9 버전 이전
	1. 페이지 상단에 인코딩 : request.setCharacterEncoding("UTF-8");
	2. server.xml 63 라인 >> URIEncoding="UTF-8" 추가
	 <Connector URIEncoding="UTF-8" connectionTimeout="20000" port="8090" protocol="HTTP/1.1" redirectPort="8443"/>

	한글처리 ...(POST)
	1.Tomcat 버전에 상관없이 ..
	2.받는 페이지 상단에 무조건 : request.setCharacterEncoding("UTF-8");

	JSP 페이지 상단에 무조건 ** (한글이 깨짐은 없다 ....)
	request.setCharacterEncoding("UTF-8");
	
	
	//http://localhost:8090/WebJSP/Ex02_register.jsp?userid=hong2&pwd=1004&hobby=basketball
	*/
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	클라이언트에게 전달<br>
	ID: <%= uid %><br>
	PWD: <%= pwd %><br>
	당신의 취미는:<br>
	<%
		for(String str : hobbys){
			if(!str.isEmpty()){
	%>
			hobby: <%= str %><br>
	<%		}
		}
	%>
</body>
</html>