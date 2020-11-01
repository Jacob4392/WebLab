package kr.or.bit.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class MemberDetailAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 조건에 따라 세션 인밸리데이트 해야함
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
			session.invalidate();
			response.sendRedirect("Ex02_JDBC_Main.jsp");
		}
    	
    	String id = request.getParameter("id");
    	
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	
		try {
			memberdao dao = new memberdao();
	    	koreamember dto = dao.selectAccount(id);
	    	
			request.setAttribute("member", dto);
			
			forward.setPath("/WEB-INF/Member/Ex03_MemberDetail.jsp");

		}catch (Exception e) {
			System.out.println("관리자 회원목록 불러오기 중 오류 발생 : " + e.getMessage());
		}
		
    	return forward;
	}
}
