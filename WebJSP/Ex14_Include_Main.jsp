<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		String userid = request.getParameter("userid");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	type:<%= type %><br> 
	userid:<%= userid %><br>
	<!-- 화면 주소창에 ?type=jgdoh&userid=1234 parameter 값을 입력받음-->
	<jsp:include page="Ex14_param.jsp">
		<jsp:param value="baseball" name="hobby"/>
		<jsp:param value="1004" name="pwd"/>
	</jsp:include>	

</body>
</html>