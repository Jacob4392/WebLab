<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p><a href="Ex02_JDBC_Main.jsp">Main</a></p>
<c:if test="${empty sessionScope.userid}">
	<p><a href="Ex02_JDBC_Login.jsp">Login</a></p>
	<p><a href="Ex02_JDBC_JoinForm.jsp">Register</a></p>
</c:if>
<p><a href="#">Intro</a></p>
<p><a href="#">Intro</a></p>