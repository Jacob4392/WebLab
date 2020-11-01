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
import kr.or.bit.service.Delete;
import kr.or.bit.service.Detail;
import kr.or.bit.service.Edit;
import kr.or.bit.service.Join;
import kr.or.bit.service.LoginInput;
import kr.or.bit.service.MemberListService;
import kr.or.bit.service.Search;
import kr.or.bit.service.Update;

@WebServlet("*.member")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberFrontController() {
        super();
    }
      
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String requestURI = request.getRequestURI();
    		String contextPath = request.getContextPath();
    		String url_Command = requestURI.substring(contextPath.length());

        	System.out.println("requestURI : " + requestURI);
        	System.out.println("contextPath : " + contextPath);
        	System.out.println("url_Command : " + url_Command);
        	
        	ActionForward forward = null;
        	Action action = null; 
        	
        	String viewpage="";
        	
        	if(url_Command.equals("/MemberList.member")) {
        		action = new MemberListService();
        		forward = action.execute(request, response);
        	}else if(url_Command.equals("/Login.member")) {
        		forward = new ActionForward();
        		forward.setRedirect(false);
        		forward.setPath("/WEB-INF/views/Ex02_JDBC_Login.jsp");
        	}else if(url_Command.equals("/Logout.member")) {
        		forward = new ActionForward();
        		forward.setRedirect(false);
        		forward.setPath("/WEB-INF/views/Ex02_JDBC_Logout.jsp");
        	}
        	else if(url_Command.equals("/Joinform.member")) {
        		forward = new ActionForward();
        		forward.setRedirect(false);
        		forward.setPath("/WEB-INF/views/Ex02_JDBC_JoinForm.jsp");
        	}else if(url_Command.equals("/Logininput.member")) {
        		action = new LoginInput();
        		forward = action.execute(request, response);
        	}else if(url_Command.equals("/join.member")) {
        		action = new Join();
        		forward = action.execute(request, response);
    		
        	}else if(url_Command.equals("/delete.member")) {
        		action = new Delete();
        		forward = action.execute(request, response);
    		
        	}else if(url_Command.equals("/detail.member")) {
        		action = new Detail();
        		forward = action.execute(request, response);
    		
        	}else if(url_Command.equals("/Edit.member")) {
        		action = new Edit();
        		forward = action.execute(request, response);
    		
        	}else if(url_Command.equals("/update.member")) {
        		action = new Update();
        		forward = action.execute(request, response);
    		
        	}else if(url_Command.equals("/search.member")) {
        		action = new Search();
        		forward = action.execute(request, response);
    		
        	}
        	
        	
        	
        	if(forward != null) {
        		if(forward.isRedirect()) { //true 
        			response.sendRedirect(forward.getPath());
        		}else {
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
