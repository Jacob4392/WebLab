<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

/*
	요청에 대한 흐름제어
	
	1. include(디자인적인 요소)
	2. forward(흐름제어: 요청시 다른 페이지 서비스를 하고 싶을 때)
	
	공통점: request 객체를 공유한다
	
	차이점: include는 제어권을 가지고 있다
		  forward는 제어권을 넘겨준다(point: 요청주소는 동일한데 서비스 페이지를 다르게 할 수 있다)
		  
*/
	String code = request.getParameter("code");
	String viewUri = null;
	if(code.equals("a")){
		viewUri = "/forward/a.jsp";
	}else if(code.equals("b")){
		viewUri = "/forward/b.jsp";
	}else if(code.equals("c")){
		viewUri = "/forward/c.jsp";
	}
%>
<jsp:forward page="<%= viewUri %>" />
<!-- 의미가 없다 디자인이 없음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	123
</body>
</html>