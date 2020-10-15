<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb" autoFlush="true" %>    
<!--  
page buffer="8kb" autoFlush="true" 설정을 하지 않아도
default : 8kb  ,,, true
page 내용이 buffer 채우면 자동으로 flush
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//출력객체 (System.out.println() >> 동일한 역할 객체 >> out 객체)
		//페이지에서 더 이상 출력할 내용이 없으면 자동 flush
		for(int i = 0 ; i < 10 ;i++){
			out.print("<b>" + i +"<b><br>");
		}
	%>
	
</body>
</html>






