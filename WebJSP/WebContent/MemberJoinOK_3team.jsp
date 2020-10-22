<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userId");
String userName = request.getParameter("userName");
String userPass = request.getParameter("userPass");
String userPassCheck = request.getParameter("userPassCheck");
String userEmail = request.getParameter("userEmail");
String userSsn1 = request.getParameter("userSsn1");
String userSsn2 = request.getParameter("userSsn2");
String userZipCode = request.getParameter("userZipcode");
String userAddr1 = request.getParameter("userAddr1");
String userAddr2 = request.getParameter("userAddr2");
String userPhone = request.getParameter("userPhone");
String[] gender = request.getParameterValues("gender");
String[] hobbys = request.getParameterValues("hobby");
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

%>
<!-- submit 전송시 
    userId , userPass , userPassCheck , userEmail , userPhone
    , userSsn1 , userSsn2 , userZipCode , userPhone
       값이 입력되지 않으면 다시 입력을 요청 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   ID:<%=userId%><hr>   
   이름:<%=userName%><hr>   
   비밀번호:<%=userPass%><hr>   
   e-mail:<%=userEmail%><hr>   
   주민번호:<%=userSsn1 %>-<%=userSsn2%><hr>   
   
   세부주소:<%=userAddr1 %><%=userAddr2 %><hr>   
   전화번호:<%=userPhone %><hr>   
   성별:<%for(String g : gender){ %>
   <%= g %><%} %><hr>
   <ul>취미<%
   if(hobbys!=null)
   for(String str : hobbys){
%>
   <li><%= str %></li>
<%
   }else %>
   </ul><hr>
   가입일:<%=year %>년<%=month %>월<%=day %>일<hr>

</body>
</html>