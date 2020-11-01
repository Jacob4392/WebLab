package kr.or.bit.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class MemberEditAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws UnsupportedEncodingException {
		
		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 요청 받기
		String id = request.getParameter("id");

		memberdao dao = new memberdao();
		
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
		
		try {
			
			koreamember km = dao.selectAccount(id);
			
			response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
			
			request.setAttribute("koreamember", km);
			
			forward.setPath("/WEB-INF/Member/Ex03_MemberEdit.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
