<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	/*
	**<c:set >:변수 생성, 값을 저장 하는 역할. 자바 객체 변수 value="
	<c:remove>: 변수 삭제
	**<c:if> : 조건문(test="조건절작성(EL)") (else if가 없음)
	**<c:choose> : 여러가지를 조건별로 처리가 가능하다(if보다 활용도가 높음)
	***<c:forEach>: 반복문 처리 (jquery each와 비슷)
	<c:forTokens>: for문과 split과의 결합
	<c:out> : JSTL의 출력구문(이것보다는 EL표현식이 더 많이 사용됨 >> ${} 빈도가 더 높음)
	<c:catch>:예외처리
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL parameter</h3>
	${ param.id } - ${ param.userpwd }<br>
	
	<h3>EL parameter 값을 변수에 저장할 수 있습니다.</h3>
	<c:set var="userid" value="${ param.id }"/>
	<c:set var="userpwd" value="${ param.userpwd }"/>
	<hr>
	<h3>JSTL 변수값 출력하기</h3>
	id: ${ userid }<br>
	pwd: ${ userpwd }<br>
	<hr>
	<c:if test="${ !empty userpwd }"> <!-- password 값이 비어있지 않다면 -->
		<h3>not empty userpwd</h3>
		<c:if test="${ userpwd == '1004' }">
			<h3>welcome Admin page</h3>
		</c:if>
	</c:if>
</body>
</html>