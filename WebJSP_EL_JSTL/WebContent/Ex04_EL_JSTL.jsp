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
<%
	String id = request.getParameter("id");
	if(id.equals("hong")){
%>
	<%=id %><img src="images/puppy.jpg" style="width:100px;height:100px">
<%		
	}
%>

<h3>EL & JSTL 사용하기</h3>
	<c:if test="${param.id == 'hong'}">
		${param.id}<img src="images/puppy.jpg" style="width:100px;height:100px">
	</c:if>
	
<h3>JSTL IF문 사용하기</h3>
	<!-- http://192.168.0.8:8090/WebJSP_EL_JSTL/Ex04_EL_JSTL.jsp?id=hong&age=25 -->
	<c:if test="${param.age >20}" var="result">
		param.value: ${ param.age }<br>
	</c:if>
	if 구문에서 만들었던 var 변수값은 : ${ result }<br>

</body>
</html>