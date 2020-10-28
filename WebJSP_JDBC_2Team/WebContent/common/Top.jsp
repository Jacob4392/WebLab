<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="Ex02_JDBC_Main.jsp">Main</a>&nbsp;&nbsp;&nbsp;||
<c:if test="${empty sessionScope.userid}">
	<a href="Ex02_JDBC_Login.jsp">Login</a>&nbsp;&nbsp;&nbsp;||
	<a href="Ex02_JDBC_JoinForm.jsp">Register</a>&nbsp;&nbsp;&nbsp;||
</c:if>
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;

<!-- Ex02_JDBC_loginok.jsp애서 로그인 시에 session객체에 setAttribute("userid",..)
	JSTL sessionScope 이용-->
<c:choose>
	<c:when test="${not empty sessionScope.userid}">
		<b>[${sessionScope.userid}]</b> 로그인 상태입니다.
		<a href='Ex02_JDBC_Logout.jsp'>[ 로그아웃 ]</a>
	</c:when>
	<c:otherwise>
		<b>[로그인 하지 않으셨네요]</b>
		<a href='Ex02_JDBC_Login.jsp'>[ 로그인 ]</a>
	</c:otherwise>
</c:choose>