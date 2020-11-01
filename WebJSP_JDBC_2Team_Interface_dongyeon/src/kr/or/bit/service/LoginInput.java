package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class LoginInput implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd"); // 브라우저페이지에서 사용자가 입력한 값

		
		memberdao m = new memberdao();
		koreamember km = m.isExist(id);
		
		String msg = "";
		String url = "";
		
		if(km != null) {
			if(km.getId().equals(id)) {
				if(km.getPwd().equals(pwd)) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", id);
				msg="로그인 성공";
				url="Ex02_JDBC_Main.jsp";
				}else {
					
					msg="비밀번호가 틀립니다.";
					url="/WEB-INF/views/Ex02_JDBC_Login.jsp";
				}
			}
			}else {
				msg="등록된 회원이 아닙니다. 회원가입부터 해주세요";
				url="/WEB-INF/views/Ex02_JDBC_JoinForm.jsp";
			}
			request.setAttribute("board_msg",msg);
		    request.setAttribute("board_url", url);
		
		    ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/views/redirect.jsp");
		    
		return forward;

	}
	

}
