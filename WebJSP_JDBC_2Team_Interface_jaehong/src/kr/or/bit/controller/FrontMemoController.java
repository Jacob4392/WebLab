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
import kr.or.bit.service.DeleteService;
import kr.or.bit.service.DetailService;
import kr.or.bit.service.EditService;
import kr.or.bit.service.LoginService;
import kr.or.bit.service.MemberListService;
import kr.or.bit.service.SearchService;
import kr.or.bit.service.UpdateService;
import kr.or.bit.service.signUpService;


@WebServlet("*.do")
public class FrontMemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontMemoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//***************************************************
    	request.setCharacterEncoding("UTF-8");
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action=null;
    	ActionForward forward=null;
    	
    	if(url_Command.equals("/loginPage.do")) { 
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Ex02_JDBC_Login.jsp");
    	}else if(url_Command.equals("/SignUpPage.do")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Ex02_JDBC_JoinForm.jsp");
    	}else if(url_Command.equals("/main.do")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/Ex02_JDBC_Main.jsp");
    	}else if(url_Command.equals("/login.do")) {
    		action = new LoginService();
    		forward = action.execute(request, response);
    		System.out.println("LoginService 실행");
    	}else if(url_Command.equals("/signUp.do")) {
    		action = new signUpService();
    		forward = action.execute(request, response);
    		System.out.println("signUpService 실행");
    	}else if(url_Command.equals("/logOut.do")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/Register/Ex02_JDBC_Logout.jsp");
    	}else if(url_Command.equals("/memberlist.do")) {
    		action = new MemberListService();
    		forward = action.execute(request, response);
    		System.out.println("MemberListService 실행");
    	}else if(url_Command.equals("/detail.do")) {
    		action = new DetailService();
    		forward = action.execute(request, response);
    		System.out.println("DetailService 실행");
    	}else if(url_Command.equals("/delete.do")) {
    		action = new DeleteService();
    		forward = action.execute(request, response);
    		System.out.println("DeleteService 실행");
    	}else if(url_Command.equals("/update.do")) {
    		action = new UpdateService();
    		forward = action.execute(request, response);
    		System.out.println("UpdateService 실행");
    	}else if(url_Command.equals("/edit.do")) {
    		action = new EditService();
    		forward = action.execute(request, response);
    		System.out.println("EditService 실행");
    	}else if(url_Command.equals("/search.do")) {
    		action = new SearchService();
    		forward = action.execute(request, response);
    		System.out.println("SearchService 실행");
    	}
    	
    	
    	
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		}else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
