<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty sessionScope.userid}">
		<%response.sendRedirect("Ex02_JDBC_Login.jsp"); %>
	</c:when>
	<c:when test="${sessionScope.userid != 'admin'}">
		<%response.sendRedirect("Ex02_JDBC_Login.jsp"); %>
	</c:when>
</c:choose>

<%-- <c:if test="${empty sessionScope.userid}">
	<%response.sendRedirect("Ex02_JDBC_Login.jsp"); %>
	<c:if test="${sessionScope.userid != 'admin'}">
		<%response.sendRedirect("Ex02_JDBC_Login.jsp"); %>
	</c:if>
</c:if> --%>