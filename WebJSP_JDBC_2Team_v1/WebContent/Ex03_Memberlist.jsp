<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	 1.관리자만 접근 가능한 페이지
	 2.로그인한 일반 회원이 주소값을 외워서 ... 접근불가 
	 3.그러면  회원에 관련되 모든 페이지 상단에는 아래 코드를 ..... : sessionCheck.jsp >> include 
	 => <jsp:include page="/common/Check.jsp"/>
%> --%>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	table {
		border: solid 2px black;
		border-collapse: collapse;
	}
	
	tr {
		border: solid 1px blue;
		background-color: white;
		color: black;
	}
	
	td {
		border: solid 1px red;
	}
	</style>
</head>
<body>
	<jsp:include page="/common/Check.jsp"/>
	<table style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"/></td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"/></td>
			<td style="width: 700px">
				<table style="width: 400px; height: 100px; margin-left: auto; margin-right: auto">
					<tr>
						<th colspan="4">회원리스트</th>
					</tr>
					<c:forEach var="column" items="${requestScope.memberList}">
					<tr>
						<td width="100px"><a href='MemberDetailServlet?id=${column.id}'>${column.id}</a></td>
						<td width="100px">${column.ip}</td>
						<td><a href="MemberDeleteServlet?id=${column.id}">[삭제]</a></td>
						<td><a href="MemberEditServlet?id=${column.id}">[수정]</a></td>
					</tr>
					</c:forEach>
				</table>
				
				<hr>
				
				<form action="MemberSearchServlet" method="post">
					회원명:<input type="text" name="search"> 
					     <input type="submit"value="이름검색하기">
				</form>
				<hr>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>