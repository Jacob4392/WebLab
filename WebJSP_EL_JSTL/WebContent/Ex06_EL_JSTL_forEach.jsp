<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.or.bit.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL for</h3>
	<!-- 
		java코드
		int sum = 0;
		for(int i=0; i<=10; i++){
			sum+=i;
		}
		
		for(String s : list){}
		
	 -->
	 
	 <c:forEach var="i" begin="1" end="10">
	 	<c:set var="sum" value="${ sum+i }"/>
	 	${ i }<br>
	 </c:forEach>
	 sum의 누적 값은: ${ sum }<br>
	 
	 <h3>구구단 5단 출력하기</h3>
	 <ul>
	 	<c:forEach var="i" begin="1" end="9">
	 		<li>5*${i} = ${5*i}</li>
	 	</c:forEach>
	 </ul>
	 
	 
	 <h3>EL&JSTL 사용해서 2~9 단까지 출력(forEach를 중첩해서 사용)</h3>
	 
<%-- 	 <ul>
	 	<c:forEach var="i" begin="2" end="9">
	 		<c:forEach var="j" begin="1" end="9">
	 			<li>${ i }*${ j } = ${ i*j }</li>
	 		</c:forEach><br>
	 	</c:forEach>
	 </ul> --%>
	 <table border="1">
	 	<c:forEach var="i" begin="2" end="9">
	 		<c:forEach var="j" begin="0" end="9">
	 			<c:choose>
	 				<c:when test="${ j==0 }">
	 					<tr bgcolor="yellow"><th>${ i }단</th></tr>
	 				</c:when>
	 				<c:otherwise>
	 					<tr><td>${i}*${j}=${i*j}</td></tr>
	 				</c:otherwise>
	 			</c:choose>
	 		</c:forEach><br>
	 	</c:forEach>
	 </table>
	 
	 
	 <h3>JSTL forEach 사용하기</h3>
	 <%
	 	int[] arr = new int[]{10,20,30,40,50};
	 	for(int i : arr){
	 		out.print("출력값: <b>" + i + "</b></br>");
	 	}
	 	//EL 만 가지고 : request, session 객체에 저장
	 %>
	 <h3>EL, JAVA 객체에 대한 직접 접근이 불가능[JSTL 통해서 변수에 담아서 사용]</h3>
	 arr 객체 배열의 접근이 불가: ${arr}<br>
	 <c:set var="intarr" value="<%=arr %>"/>
	 c:set 변수에 접근: ${ intarr }<br>
	 <hr>
	 <h3>java의 개선된 for문 처리</h3>
	 <c:forEach var="i" items="${intarr}">
	 	배열값: ${i}<br>
	 </c:forEach>
	 
	 
	 <h3>위  c:set, c:forEach를 단순하게 표현하세요</h3>
	 <c:forEach var="i" items="<%=arr %>">
	 	배열값2: ${i}<br>
	 </c:forEach>
	 
	 
	 <h3>재미삼아서</h3>
	 <c:forEach var="i" items="<%=new int[]{1,2,3,4,5} %>">
	 	배열값3: ${i}<br>
	 </c:forEach>
	 

	 <h3>forEach parameter 활용</h3>
	 <c:forEach var="i" items="${intarr}" varStatus="status">
	 <!--status:  for문을 1번 돌면 status 객체가 만들어진다. status안에 정보가 저장이 된다 -->
	 	index: ${status.index}&nbsp;&nbsp;&nbsp;
	 	count: ${status.count}&nbsp;&nbsp;&nbsp; <!-- 배열의 갯수 -->
	 	value: ${i}<br>
	 </c:forEach>
	 <hr>
	 
	 <h3>Today Point (모르면 게시판 화면 구성 못해요..)</h3>
	 <%
	 	//사원 정보를 담는 테이블
	 	//전체 조회를 하는 함수: List<Emp> getEmpAllList(){return}
	 	List<Emp> emplist = new ArrayList<>();
	 	emplist.add(new Emp(1000,"A"));
	 	emplist.add(new Emp(2000,"B"));
	 	emplist.add(new Emp(3000,"C"));
	 	
	 	//{return emplist}
	 	for(Emp e : emplist){
	 		out.print(e.getEmpno() + "/" + e.getEname() + "<br>");
	 	}
	 	//jsp 화면에서 그 결과(목록)를 출력하세요
	 	//사실은 
	 	request.setAttribute("list", emplist);
	 	//forward >> jsp에게
	 	//EL> requestScope.list
	 	
	 
	 	
	 %>
	 <h3>EL&JSTL을 통해서 결과를 화면에 출력</h3>
<%-- 	 <c:set var="list" value="<%=emplist %>"/>
	 <table border="1">
	 	<tr>
	 		<td>사번</td><td>이름</td>
	 	</tr>	
	 	<c:forEach var="emp" items="${list}">
	 		<tr>
	 			<td>${emp.empno}</td><td>${emp.ename}</td>
	 		</tr>
	 	</c:forEach> 
	 </table> --%>
	 
	 <table border="1">
	 	<tr>
	 		<td>사번</td><td>이름</td>
	 	</tr>	
	 	<c:forEach var="emp" items="<%=emplist %>">
	 		<tr>
	 			<td>${emp.empno}</td><td>${emp.ename}</td>
	 		</tr>
	 	</c:forEach> 
	 </table>
	 
	 <h3>Java Map 객체 받아서  EL & JSTL 사용하여 출력하기(key,value)</h3>
	 <%
	 	Map<String,Object> hm = new HashMap<>();
	 	hm.put("name","hong");
	 	hm.put("pwd","1004");
	 	hm.put("date",new Date());
	 	
	 %>
	 <c:set var="hm" value="<%=hm %>"/>
	 <c:forEach var="obj" items="${hm}">
	 	${obj.key} - > ${obj.value}<br>
	 </c:forEach>
	 
	key:name : ${hm.name}<br>
	key:pwd : ${hm.pwd}<br>
	key:date : ${hm.date}<br>
	
	<h3>옵션</h3>
	<h3>JSTL 구분자 처리하기</h3>
	<c:forTokens  var="token"  items="A.B.C.D" delims=".">
			${token}<br>
	</c:forTokens>
	
	<h3>JSTL 복합구분자 처리하기</h3>
	<c:forTokens  var="token"  items="A.B/C-D" delims="./-">
			${token}<br>
	</c:forTokens>

	
	<!-- 
		forEach
		step = -1 마이너스 값은 불가...
	 -->
	 <c:set var="nownum" value="10"/>
	 <c:forEach var="i" begin="0" end="${nownum}" step="1">
	 	${nownum-i}<br>
	 </c:forEach>
	 
	 <select>
	 	<c:forEach var="i" begin="0" end="${2016-1900}">
	 		<c:set var="yearoption" value="${2016-i}"/>
	 		<option value="${yearoption}">${yearoption}</option>
	 	</c:forEach>
	 </select>
	 
	 
</body>
</html>