package kr.or.bit.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class Update implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg ="";
		String url ="";
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		try {
			memberdao dao = new memberdao();
			
			int n = dao.updateMember(new koreamember(id,name,age,gender,email));
			if(n > 0) {
				msg="수정이 완료 되었습니다.";
				url="MemberList.member";

			}else {
				msg="다시 시도해 주세요";
				url="MemberList.member";
			}
		} catch (Exception e) {
			msg="다시 시도해 주세요";
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
