<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 코드 사용
	//목적지 주소 페이지 
	//클라이언트 [ 입력한 정보 ]를 받는다 
	//<input type="text"    name="id">
    //<input type="password" name="pwd">
    
    String userid =  request.getParameter("id");
    String pwd = request.getParameter("pwd");
    
    //DB 연결  >> select >> insert  업무에 따라서

    
%>        
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 입력한 데이터</h3>
	ID : <%= userid %><br>
	PWD: <%= pwd %><br>
</body>
</html>