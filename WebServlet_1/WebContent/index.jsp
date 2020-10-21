<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 요청하기</title>
</head>
<body>
	<a href="">이전</a>
	<a href="">다음</a>
	<br>
	<p>index.jsp</p><br><br>
	
	<h3>servelt 요청하기</h3>
	<h3>ContextPath()</h3><%=request.getContextPath() %><hr>
	<a href="<%=request.getContextPath() %>/simple">일반요청하기</a>
	<br>
	<a href="<%=request.getContextPath() %>/simple?type=date">날짜요청하기</a>
	<br>
	<a href="<%=request.getContextPath() %>/simple?type=abcd">비정상요청하기</a>
	<br>
</body>
</html>