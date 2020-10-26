<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("userid"); //단일 값을 받는 것
	//request.getParameterValues(name); //checkbox 등의 다중값을 받는 수단

	request.setAttribute("name", "korea");
	session.setAttribute("user", "bit");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--

EL(출력 표현식) : JSP 페이지에서 사용되는 스크립트 언어(화면출력) 스크립트릿, out.print ...
이유 : 스파게티 (% 부분과 html 혼재되는 코드) >> 유지보수 , 코드의 해석(가독성)
문제를 해결(개선) 위해서 [html 잘 어울려야 되고 서버쪽 코드 출력 ] Script
>> EL & JSTL 탄생 (단점 : JSP 페이지에서만 사용가능)
EL : JSP 페이지에서 화면의 출력을 목적으로 만든 script 언어 (% 없이 살자) 

EL도 또한 객체로 봅니다. 여러가지 자원을 가지고 있습니다.
​
[EL 가지고 있는 객체]
paramValues : 요청 파라미터의 <파라미터이름, 값배열> 매핑을 저장한 Map 객체
param : 요청 파라미터의 <파라미터이름, 값> 매핑을 저장한 Map 객체
requestScope : request 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체
sessionScope : session 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체
applicationScope : application 기본 객체에 저장된 속성의 <속성,값> 매핑을 저장한 Map 객체

​-->
<h3>서버코드 제어</h3>
스크립트릿:<b><%=id %></b>
스크립트릿:<%=request.getAttribute("name") %><br>
스크립트릿:<%=session.getAttribute("user") %><br>
parameter: <%=request.getParameter("userid") %><br>
<br>
<h3>EL 출력식</h3>
EL param객체 이용하여 parameter 출력: ${param.userid}<br> <!--  -->
EL request value : ${requestScope.name}<br>
EL request value : (requestScope.속성명) : ${name}<br>
EL session value : ${sessionScope.user}<br>
EL session value : (sessionScope.속성명) : ${user}<br>

<h3>EL 출력에 대한 기본 문법</h3>
스크립트릿 : <%= 1 + 5 %><br>
EL : ${100+200}<br>
EL : ${"1" + 1} <br> <!-- 문자형 숫자 (자동 형변환) >> 숫자 >> 연산 -->
EL : ${1==1}<br>
EL : ${false}<br>
EL : ${!false}<br>
EL : ${empty x}<br><!-- x라는 변수의 값이 비어있나요? -->

</body>
</html>