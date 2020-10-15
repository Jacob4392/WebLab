<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>SITE MAIN PAGE 상단내용</h3>
			<hr>
				<jsp:include page="/commonmodule/sub.jsp"></jsp:include>
			<hr>
			<!-- 요청의 흐름이 변경된다 MAIN -> sub -> MAIN -->
		<h3>SITE MAIN PAGE 하단내용</h3>

</body>
</html>