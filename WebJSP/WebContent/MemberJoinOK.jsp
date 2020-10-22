<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
	
/*
받아와야할 정보		네임
------------------------------
아이디			userId
이름			userName
패스워드			userPass
패스워드 확인	userPassCheck
성별			gender
이메일			userEmail
주민 앞			userSsn1
주민 뒤			userSsn2
우편번호			userZipCode
주소1			userAddr1
주소2			userAddr2
폰				userPhone
취미**			hobby
생년월일 (은 받지말아보자)
** : 배열일듯
*/

String id = request.getParameter("userId");
String name = request.getParameter("userName");
String pwd = request.getParameter("userPass");
String pwdcheck = request.getParameter("userPassCheck");
String gender = request.getParameter("gender");
String email = request.getParameter("userEmail");
String ssn1 = request.getParameter("userSsn1");
String ssn2 = request.getParameter("userSsn2");
String zipcode = request.getParameter("userZipCode");
String addr1 = request.getParameter("userAddr1");
String addr2 = request.getParameter("userAddr2");
String phone = request.getParameter("userPhone");
String[] hobbies = request.getParameterValues("hobby"); 


	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사용자ID:		<%=id %><br>
	사용자이름:	<%=name %><br>
	비밀번호:		<%=pwd %><br>
	비밀번호 확인:	<%=pwdcheck %><br>
	성별:			<%=gender %><br>
	이메일:		<%=email %><br>
	주민번호 앞자리:	<%=ssn1 %><br>
	주민번호 뒷자리:	<%=ssn2 %><br>
	우편번호:		<%=zipcode %><br>
	주소:			<%=addr1 %><br>
	상세주소:		<%=addr2 %><br>
	핸드폰번호:	<%=phone %><br>
	취미:			<%
			if(hobbies != null){
				for(String hobby : hobbies){
					out.print(hobby + "&nbsp;&nbsp;&nbsp;");
				}
			}else{
				out.print("취미를 선택하지 않으셨습니다.");
			}
	
	%>
</body>
</html>