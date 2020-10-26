<%@page import="java.util.HashMap"%>
<%@page import="kr.or.bit.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	Emp e = new Emp();
	e.setEmpno(2000);
	e.setEname("bituser");
	
	HashMap<String,String> hp = new HashMap<>();
	hp.put("data","1004");
	hp.put("data2","1004");
			
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>기존방식</h3>
	<%=e %><br> <!-- 여기의 %를 없애기 위해 EL&JSTL을 적용하는 것 -->
	<%=e.getEmpno() %><br>
	<%=e.getEname() %><br>
	
	<h3>EL 출력</h3>
	자바 객체 출력하기(자바 객체에 대한 직접적인 접근이 불가하다): ${e}<br> <!--EL은 자바의 객체에 대한 직접접근이 안된다 -->
	<h3>request, session 객체에 담으면 EL에 접근 가능합니다</h3>
	${e.getEmpno()}<br> <!-- 바로 e를 찍어서 볼수는 없다 -->
	${e.getEname()}<br>
	
	1.JSTL(core): 변수 생성, 제어문<br>
	<c:set var="m" value="<%=e %>"/>
	JSTL을 사용해서 변수 m을 생성하고 (그 변수를 출력하는 방법): ${m}<br>
	getter호출(EL에서 잘 안씁니다): ${m.getEmpno()}<br>
	EL 출력:(m.member field명: getter 함수 자동 호출): ${m.empno}<br>
	EL 출력:(m.member field명: getter 함수 자동 호출): ${m.ename}<br>
	
	<hr>
	<h3>EL & JSTL 사용하기</h3>
	*****EL을 통해서 JAVA 객체에 대한 직접적인 접근은 불가합니다 *****<br>
	방법:1. request,session 객체에 담아서 접근<br>
	방법:2. JSTL 변수를 사용해서 사용<br>
	
	<c:set var="username" value="${m.ename}"/>
	변수값 출력: ${username}<br>
	<hr>
	<h3>JSTL 변수 만들고 scope 정의하기</h3>
	<c:set var="job" value="농구선수" scope="request"/>
	<!-- scope="request"의 의미? forward된 페이지에서 그대로 사용할 수 있다는 뜻 -->
	<!-- scope="page" 하면 이 페이지에서만 사용할 수 있습니다. -->
	당신의 직업은 ${job}<br>
	만약에 당신이 include, forward 한 페이지가 있다면 그 페이지에서 'job'변수 사용이 가능합니다.
	
	<hr>
	<c:set var="job2" value="야구선수" scope="request"/>
	값출력: ${job2}<br>
	만든 변수를 삭제하는 기능이 있습니다.
	<c:remove var="job2"/><br>
	job2 변수 삭제: ${job2}<br> <!-- EL&JSTL의 장점: 값이 없으면 에러를 안내고 그저 안나올 뿐 -->
	
	<hr>
	hp객체에 대한 HashMap(직접접근 불가): ${hp}<br>
	<c:set var="vhp" value="<%=hp %>"/> <!-- %= 대체할 수 있는 언어 -->
	hp객체: ${vhp}<br>
	hp객체: ${vhp.data}<br>
	
	<!--hp.put("color","red") 와 동일한 기능이 가능하다-->
	<c:set target="${vhp}" property="color" value="red"/> <!-- 잘 사용하지는 않음, 출력이 목적인 언어이기 때문에 -->
	<%-- target: 실제 접근할 객체의 주소 --%>
	hp객체: ${vhp}<br>
	
	
</body>
</html>