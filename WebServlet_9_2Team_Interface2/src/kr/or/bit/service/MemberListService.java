package kr.or.bit.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class MemberListService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
    
		try {
			memberdao dao = new memberdao();
			List<koreamember> memberList = dao.getDAOAllList();
			request.setAttribute("memberList", memberList);
			
			forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/Ex03_Memberlist.jsp");
			
		}catch (Exception e) {
			System.out.println("관리자 회원목록 불러오기 중 오류 발생 : " + e.getMessage());
		}
    
    
		
		return forward;
	}
	

}
