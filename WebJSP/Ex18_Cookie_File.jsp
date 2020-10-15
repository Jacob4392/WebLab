<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	1.메모리 쿠키(브라우저 쿠키): Client 강제로 삭제하지 않는 한
							브라우저 닫기 전까지는 유효(소멸타입: -1)
	2. 파일쿠키(소멸시간): Client 강제로 삭제하지 않는 한
						정해진 시간까지 생존(유효)(2020년 00월 00일)
	
	setMaxage(60) >> 60초
	30일
	(30*24*60*60) 일*시*분*초
	setMaxage(30*24*60*60)
 -->
<%
	Cookie cookie = new Cookie("bit", "hong");
	cookie.setMaxAge(30*24*60*60); //30일
	response.addCookie(cookie);
	
%>


</body>
</html>