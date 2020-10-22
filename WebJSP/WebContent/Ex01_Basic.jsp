
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% //스크립트릿
    	/*
    		JSP 페이지: UI(html + css + javascript) + Java(로직, DB:JDBC)
    		Java 코드 (<% 안쪽에 구현)
    		
    		JSP페이지 >> 디자인 코드 + 서버 로직 코드 >> 혼재되어 있음(유지보수가 어려움)
    		장점: 단순한 웹페이지를 작성하거나 배우기 편하다. 디자인이 편하고, 심플하다
    		
    		JSP 구성요소
    		1.선언부(JSP의 페이지에 대한 기본설정 세팅)
    		<%@ page language="java"
    		page 지시자: 사용언어, 인코딩, import ...
    		
    		2.스크립트 요소
    		2.1 스크립트 릿 : <% java 코드 구현 영역
    		2.2 표현식 (출력방법): 출력하는 대상(client 웹브라우저에게 전달) : <%= 
    			= : response
    		2.3 선언부(공통적인 자원(page scope)) : 공통함수 >> <%! 공통 자바코드를 구현한다
    		
    		>>JSP와 HTML 차이점
    		1.처리방법: 
    			1.1 JSP(WAS -> 컴파일 -> _jsp.java -> _jsp.class 
    					-> 변환(text,html,script) -> 응답)
    				정적자원 + 동적자원(java 코드) >> 정적자원을 만들어 서비스
    				<% 안의 코드가 수정되면 다시 컴파일 > 처리(서비스) > WAS가 자동 처리
    			1.2 HTML(Web Server: 요청 -> 응답) -> 해석의 주체: 웹브라우저
    			
    		>>[결론]
    		최종적으로는 MVC 패턴을 통한 웹 개발을 해야함
    		>>일반 java 파일 		=> Model
    		>>jsp 파일			=> View
    		>>servlet 파일		=> Controller
    		>>분업화(잘하는 것만 하자)
    		
    		M : Model(DTO(data를 담을 수 있는 클래스), DAO(DB작업을 하는 클래스)) 
    		V : View (화면을 구성하는 작업: Server쪽 코드를 받아서)
    		C : Controller (조정자: 요청의 흐름을 제어 : 클라이언트 요청 처리)
    		
    		중간프로젝트: model2 기반의 MVC 웹프로젝트
    		
    		*DAO : Data Access Object    	
    		*model1: JSP만 가지고 개발하는 것을 가리킴 
    	*/
    		
    		
    	Date day = new Date(); //java 코드 
    %>
    <%!
    	//이 페이지에서 공통 함수를 사용한다면 이곳에
    	public int add(int i, int j){
    		return i + j;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello World<br>
	<%= day %><br>
	<%
		int result = add(100,200);
	%>
	<hr>
	함수 호출 결과: <%= result %>
</body>
</html>