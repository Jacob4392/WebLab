<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL out 출력객체</h3>
	<c:out value="<p>이 태그는 문단 태그입니다</p>"/><br><!-- <p> => 문자열로 넘어갑니다 -->
	&lt;p&gt; 태그는 문단을 정의합니다.
	
	<hr>
	
	<!-- JSTL 예외처리가 가능합니다 
		c:catch 안에서 예외가 발생하면 그 예외에 대한 객체가 만들어집니다.
		var="msg" >> msg 변수에 >> 예외에 대한 정보가 들어갑니다.
	-->
	<h3>예외처리</h3>
	<c:catch var="msg"> <!-- 버퍼에 쌓이는 내용이 msg에 -->
		name: <%= request.getParameter("name") %>
		<%
			if(request.getParameter("name").equals("hong")){
				out.print("당신의 이름은: " + request.getParameter("name"));
			}
		%>
	</c:catch>
	
	<%-- <c:catch var="msg"> <!-- 버퍼에 쌓이는 내용이 msg에 -->
		name: <%= request.getParameter("name") %>
		<%
			if(request.getParameter("name").equals("hong")){
				out.print("당신의 이름은: " + request.getParameter("name"));
			}
		%>
	</c:catch> --%>
	<c:if test="${msg != null}">
		<h3>예외발생</h3>
		오류메시지: ${msg}<br>
	</c:if>
</body>
</html>