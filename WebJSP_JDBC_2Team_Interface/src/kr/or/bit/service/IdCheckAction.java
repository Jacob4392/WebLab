package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;

public class IdCheckAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	String data = request.getParameter("data");
    	//System.out.println(data);
    	
    	PrintWriter out = response.getWriter();
    	memberdao md = new memberdao();
    	String check = md.IdIsExist(data);
    	
    	String responseData = "";
    	
    	if(check.equals("true")) {
    		responseData = "true";
    	}else {
    		responseData = "false";
    	}
    	
    	
    	out.print(check);
    	
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	forward.setPath("/WEB-INF/Member/Ex03_MemberDetail.jsp");
		
		return forward;
	}
}
