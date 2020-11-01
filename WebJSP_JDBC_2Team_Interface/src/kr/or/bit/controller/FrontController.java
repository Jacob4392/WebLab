package kr.or.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.JoinAction;
import kr.or.bit.service.LoginAction;
import kr.or.bit.service.LogoutAction;
import kr.or.bit.service.MemberDeleteAction;
import kr.or.bit.service.MemberDetailAction;
import kr.or.bit.service.MemberEditAction;
import kr.or.bit.service.MemberListAction;
import kr.or.bit.service.MemberSearchAction;
import kr.or.bit.service.MemberUpdateAction;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }


    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 받기
    	//String command  = request.getParameter("cmd")
    	//Url 방식은 cmd parameter 없어요
    	
    	//주소값
    	//register.do
    	//registerok.do
    	//regiseterlist.do
    	
    	//주소 요청의 판단 근거 (함수)
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());

    	
    	//requestURI :  /WebServlet_7_Member_Model2_Mvc_Url/Register.do
    	//contextPath : /WebServlet_7_Member_Model2_Mvc_Url
    	//url_Command : /Register.do
    	System.out.println("requestURI: " + requestURI);
    	System.out.println("contextPath: " + contextPath);
    	System.out.println("url_Command: " + url_Command);

    	
    	//추가코드////////////////////////////////////////////
    	//redirect 와 path 정보를 갖는 클래스
    	//Action 인터페이스 타입은 모든 자식객체의 주소값을 가질 수 있다
    	ActionForward forward = null;
    	Action action = null;

    	///////////////////////////////////////////////////
    	//2. 요청 판단 처리 (화면 , 처리)
    	String viewpage = "";
    	if(url_Command.equals("/Join.do")) {
    		//UI제공 (서비스 클래스 (x)) >> 표준화 //화면단을 보여주는 것이면 서비스 클래스가 필요없음
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Ex02_JDBC_JoinForm.jsp");
    		
    	}else if(url_Command.equals("/Joinok.do")) {
    		//UI제공 + 로직처리
    		action = new JoinAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/Login.do")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Ex02_JDBC_Login.jsp");
    		
    	}else if(url_Command.equals("/Loginok.do")) {
    		action = new LoginAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/MemberList.do")) {
    		action = new MemberListAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/MemberDetail.do")) {
    		action = new MemberDetailAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/MemberDelete.do")) {
    		action = new MemberDeleteAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/MemberEdit.do")) {
    		action = new MemberEditAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/MemberUpdate.do")) {
    		action = new MemberUpdateAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/MemberSearch.do")) {
    		action = new MemberSearchAction(); //다형성
    		forward = action.execute(request, response);
    		
    	}else if(url_Command.equals("/Main.do")){
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/Ex02_JDBC_Main.jsp");
    		
    	}else if(url_Command.equals("/Logout.do")){
    		action = new LogoutAction(); //다형성
    		forward = action.execute(request, response);
    	}
    	

    	//4. 뷰 지정하기
    	//RequestDispatcher dis = request.getRequestDispatcher(viewpage);
    	if(forward != null) {
    		if(forward.isRedirect()) {//true
    			response.sendRedirect(forward.getPath());
    		}else { //false (모든자원 사용)
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    	
    	
    	//5. forward(request 객체의 주소값을 공유)
    	//dis.forward(request, response);
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
