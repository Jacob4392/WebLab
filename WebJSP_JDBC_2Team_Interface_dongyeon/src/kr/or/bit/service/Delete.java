package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;

public class Delete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
			
		String msg="";
		String url="";
		if(session.getAttribute("uesrid")==null || !session.getAttribute("userid").equals("admin")) {
			msg="권한이 없거나 세션이 만료되었습니다.";
			url="Login.member";
		}
		
		String id = request.getParameter("id");
		
		if(session.getAttribute("userid").equals("id")) {
			msg="관리자 아이디는 삭제할 수 없습니다.";
			url="MemberList.member";
		}
		try {
			memberdao dao = new memberdao();

			int rowcount = dao.deleteMember(id);
			
			if(rowcount > 0) {
				msg="정상적으로 삭제되었습니다.";
				url="MemberList.member";
			}else {
				msg="삭제에 실패하였습니다.";
				url="MemberList.member";
			}
			
		} catch (Exception e) {
			msg="삭제에 실패하였습니다.";
			url="MemberList.member";
		}
		
		
	 	request.setAttribute("board_msg",msg);
	    request.setAttribute("board_url", url);
	
	    ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/WEB-INF/views/redirect.jsp");
	
	return forward;
	}
	

}
