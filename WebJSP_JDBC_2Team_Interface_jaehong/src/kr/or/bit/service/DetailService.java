package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class DetailService implements Action{
public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
	String id = request.getParameter("id");
	
	try {
		memberdao dao = new memberdao();
    	koreamember dto = dao.selectAccount(id);
    	
		request.setAttribute("member", dto);
		
		
	}catch (Exception e) {
		System.out.println("관리자 회원목록 불러오기 중 오류 발생 : " + e.getMessage());
	}
	
	 ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/WEB-INF/Register/Ex03_MemberDetail.jsp");
	    return forward;
		
		
	}
}
