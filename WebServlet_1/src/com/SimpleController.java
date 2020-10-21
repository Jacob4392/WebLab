package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	web.xml 설정에서
 	<url-pattern>/simple</url-pattern> 의 의미는?
 	localhost:8090/WebServlet_1/simple 요청하면
 	public class SimpleController 컴파일 실행합니다.
 	
 	
	서블릿(servlet)
	(웹서비스를 목적)으로 하는 java로 만든 파일
	서블릿 조건: extends HttpServlet >> 웹: 요청(request), 응답(response)
	servlet 은 url에서 바로 요청이 안되요 >> 요청을 Mapping하는 작업이 필요하다
	이런 이름이 들어오면 실행하라는 작업 >> mapping >> 요청주소를 생성해주어야 한다
	/SimpleController :요청주소 -> 이렇게 하면 컴파일 됨
	
	1.extends HttpServlet 반드시 상속(웹)
	2.SimpleController 서블릿 파일
	3.서블릿 파일들은 이벤트 기반의 동작을 합니다(특정 사건(이벤트)이 발생하면 자동으로 호출되는 함수가 있습니다.
	ex) 페이지가 로드되면 자동으로 호출되는 함수가 있습니다
		-protected void doGet()
		-protected void doPost() //form 태그 method? 전송방식에 대한 함수
		2개의 함수 중에서 1개가 자동 호출됩니다.
		
	클라이언트가 localhost:8090/WebServlet_1/SimpleController 이렇게 서버로 요청을 보낼것
	요청방식(GET)
	>><form method="GET" or <a href="login.jsp?num=1000">게시판</a>
	>>자동으로: protected void doGet() 호출
	//링크가 많으면 GET방식이 많고 form태그가 많으면 POST방식이 많다
	
	
	요청방식(POST)
	>><form method="POST" 라고 명시적으로 되어 있지 않은 모든 방식은 GET방식(일단)
	>>자동으로: protected void doPost() 호출
	
	doGet,doPost 호출: request의 주소값
 */

//@WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자호출");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("클라이언트 요청");
		//1.한글처리
		
		//2.사용자의 데이터 받기(요청의 의도가 무엇인지 파악하는 것)
		//ex)게시판의 글쓰기, 회원가입, 로그인 ... -> 필요한 데이터 보냄, 필요할때 DB도 요청
		String type = request.getParameter("type");
		
		//3.요청에 따른 업무를 수행한다(service)
		Object resultobj = null;
		if(type == null || type.equals("greeting")) {
			resultobj = "hello world";
		}else if(type.equals("date")) {
			resultobj = new Date();
		}else {
			resultobj = "invalid String type";
		}
		
		//4.요청 완료에 따른 결과를 저장해야 한다
		//결과를 저장하는 방법: request(현재페이지 + include, forward),
		//session(웹페이지가 포함한 모든 폴더), application 객체에 저장(scope)
		
		request.setAttribute("result", resultobj); //이 페이지에서 밖에 못 읽는다
		
		//5.저장한 결과를 Client에 전달해야 한다(화면 UI를 만들고 뿌리는 역할을 하는 JSP를 통해서 전달하고 싶음)
		//어떤 JSP를 사용할지 고른다 -> 결과를 출력할 페이지를 지정한다 >> 출력한 결과를 넘겨주고
		//출력한 결과가 request 객체에 담겨있으니, 최소한 전달해줄 때 요청된 버퍼를 비우고 ... 
		//forward 방식으로 전달 >> 제어권을 넘겨준다는 의미
		//request 객체는 >> include, forward 한 페이지에서 공유할 수 있기 때문
		
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		
		//Dispatcher: 출력 페이지를 지정하세요 (어떤 화면을 쓸거니?)
		//화면지정, 페이지, 
		//jsp의 /는 루트폴더
		//나의 결과를 /simpleview.jsp 여기에 보내겠다
		
		//저 페이지에 forward합니다(request, reponse를)
		dis.forward(request, response);
		//현재 페이지가 가지고 있는 request 객체의 주소를 전달한다
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
