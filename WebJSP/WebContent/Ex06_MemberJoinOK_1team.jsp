<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

String email = request.getParameter("userEmail");
String jumin = request.getParameter("userSsn1") + "-" + request.getParameter("userSsn2");
String userPass = request.getParameter("userPass");
String userPassCheck = request.getParameter("userPassCheck");
String gender = request.getParameter("gender");
String id = request.getParameter("userId");
String name = request.getParameter("userName");
String zipCode = request.getParameter("userZipCode");
String Addr = request.getParameter("userAddr1") + " " + request.getParameter("userAddr2");
String phone = request.getParameter("userPhone");
String[] hobbies = request.getParameterValues("hobby");
String birth = request.getParameter("year") + "년 " + request.getParameter("month") + "월 " + request.getParameter("day")
		+ "일";

String str = " ";

if (hobbies ==null ) {
	str = "취미 없음";
} else {
	for (int i = 0; i < hobbies.length; i++) {
		str += hobbies[i] + "/";
	}
}
%>
<head>
<meta charset="UTF-8">
<title>MemberJoinOK</title>
</head>
<body>

	
	<br>
	<form name="signForm" id="signForm" method="post"
		action="Ex06_MemberJoinOK.jsp">
		<table>
			<tr>
				<th colspan="2" class="title">입력정보</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" maxlength="20" id="userId" name="userId"
					title="3~16자리의 영문+숫자 조합으로 입력해주세요" value="<%=id%>" readonly></td>
				<td class="tdid"></td>
			</tr>

			<tr>
				<th>이름</th>
				<td><input type="text" maxlength="20" id="userName"
					name="userName" title="이름" value="<%=name%>" readonly></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="text" maxlength="20" id="userPass"
					name="userPass" value="<%=userPass%>"
					title="3~16자리의 영문+숫자 조합으로 입력해주세요" readonly></td>
				<td class="tdpw"></td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="text" maxlength="20" id="userPassCheck"
					name="userPassCheck" value="<%=userPassCheck%>" title="패스워드 확인" 
					readonly></td>
				<td class="tdpwch"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="text" name="gender" value="<%=gender%>"
					readonly> &nbsp&nbsp;
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" maxlength="50" id="userEmail"
					name="userEmail" title="이메일" value="<%=email%>" readonly></td>
				<td class="tdmail"></td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td><input type="text" maxlength="6" id="userSsn1"
					name="userSsn1" title="주민번호1" value="<%=jumin%>" readonly></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="text" maxlength="10" id="userZipCode"
					name="userZipCode" size="9" title="주소-우편번호" value="<%=zipCode%>" readonly>
					</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" maxlength="20" size="45" id="userAddr1"
					name="userAddr1" title="주소-기본주소" value="<%=Addr%>" readonly></td>
			</tr>

			<tr>
				<th>핸드폰번호</th>
				<td><input type="text" size="30" maxlength="20" id="userPhone"
					name="userPhone" title="'010','-'없이 입력하세요" value="<%=phone%>" readonly>
				</td>
				<td class="tdphone"></td>
			</tr>
			<tr>
				<th>취미</th>
				<td><input type="text" name="hobby" value="<%=str%>" readonly></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="year" id="year"
					value="<%=birth%>" readonly></td>
			</tr>

		</table>
	</form>



</body>
</html>