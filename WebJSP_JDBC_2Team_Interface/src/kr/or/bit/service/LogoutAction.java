package kr.or.bit.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;

public class LogoutAction implements Action{
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	forward.setPath("Ex02_JDBC_Main.jsp");
		return forward;
	}
}
