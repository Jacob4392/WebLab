<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>b.jsp 내용입니다</legend>
		요청 정보: <%= request.getParameter("code") %>
	</fieldset>
</body>
</html>