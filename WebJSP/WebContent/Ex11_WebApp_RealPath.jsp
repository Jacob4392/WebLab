 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
URI (Universal Resource Identifier)
- 인터넷상의 자원을 식별하기 위한 표기법 및 규약
- URL + URN = URI
- 인터넷 환경에서 URI는 대부분 URL을 의미, URN은 사용이 제한적


URL (Uniform Resource Locator)
- 물리적인 경로, 즉 자원의 위치 정보를 포함
- 프로토콜, 도메인, 아이피, 포트 등
- 컴퓨터로부터 접근 가능한 형태의 자원만 검색될 수 있어 제한적
- 우리가 흔히 보는 'http://test.com/test.jpg' 형태


URN (Uniform Resource Name)
- 독립적인 이름을 제공하기 위해 존재
- 자원에 대해 영속적이고 유일
- 자원의 위치와는 무관
- 예를들어 우리나라에서는 주민등록번호가 대표적



 StringBuffer url = request.getRequestURL();    // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)
 String uri = request.getRequestURI();          // URI : 프로젝트 이하 경로 (CP + SP)
 String cp = request.getContextPath();          // CP : 프로젝트 명
 String sp = request.getServletPath();          // SP : 패키지 + 파일명
 
 System.out.println("URL : " + url);
 System.out.println("URI  : " + uri);
 System.out.println("CP   : " + cp);
 System.out.println("SP   : " + sp);
 

-----------------------------------------------------------------

 URL : http://192.168.0.12:8090/WebJSP/Ex11_WebApp_RealPath.jsp
 URI  : /WebJSP/Ex11_WebApp_RealPath.jsp
 CP   : /WebJSP
 SP   : /WebJSP/Member/Ex11_WebApp_RealPath.jsp

-----------------------------------------------------------------
-->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String resourcepath ="/download/note.txt";
	out.print(resourcepath + "<br>");
	
	//http://192.168.0.12:8090/WebJSP/Ex11_WebApp_RealPath.jsp
	//    /WebJSP 실경로(소스) :  D:\bit155\WebJSP\Labs\WebJSP
	//    /WebJSP 실경로(배포 경로 ) : D:\bit155\WebJSP\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\
	
	//   /download/note.txt(소스) >>   D:\bit155\WebJSP\Labs\WebJSP\WebContent\download\note.txt
	//	 /download/note.txt(배포 경로) >>
	//D:\bit155\WebJSP\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\download\note.txt

	//WHY ??
	//웹 서비스 하기 위해서는 WAS (서버의 특정 경로에) 소스 배포
	//이클립스 WAS 내장 그래고 경로 ..... 길어 ......
	
	//Linux 서버 >> war(배포) , jar(배포)  >> 복사  >> 자동 압축 ...
	
	//파일 처리 (실경로)
	//getRealPath(배포경로)

	String realContextPath = application.getRealPath(request.getContextPath());
	//     /WebJSP (가상 경로 제공 )
	out.print("ContextPath real path : " + realContextPath + "<br>");
	//D:\bit155\WebJSP\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\

	String filePath = application.getRealPath(resourcepath); 
	//  /download/note.txt
	out.print("real path : " + filePath + "<br>");
	//D:\bit155\WebJSP\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\WebJSP\download\note.txt

    StringBuffer url = request.getRequestURL();    // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)
 	String uri = request.getRequestURI();          // URI : 프로젝트 이하 경로 (CP + SP)
 	String cp = request.getContextPath();          // CP : 프로젝트 명
 	String sp = request.getServletPath();          // SP : 패키지 + 파일명
 
 	System.out.println("URL : " + url);
 	System.out.println("URI  : " + uri);
 	System.out.println("CP   : " + cp);
 	System.out.println("SP   : " + sp);
 
 	/*
 		URL : http://192.168.0.8:8090/WebJSP/Ex11_WebApp_RealPath.jsp
 		URI  : /WebJSP/Ex11_WebApp_RealPath.jsp
 		CP   : /WebJSP
 		SP   : /Ex11_WebApp_RealPath.jsp
	*/

%>	
</body>
</html>










