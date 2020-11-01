package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class LoginService implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
				
				//2. 요청값 받기
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd"); // 브라우저페이지에서 사용자가 입력한 값
				
				memberdao m = new memberdao();
				koreamember km = m.isExist(id);
				
				//int check = 0;
				//0은 회원정보 일치
				//1은 비밀번호 틀림
				//-1은 DB에 정보가 없음 
			
				int check = 0;
				if (km != null) { 	// 회원정보가 존재할 경우
					if (km.getId().equals(id)) {
						if(km.getPwd().equals(pwd)) {
							HttpSession session = request.getSession();
							session.setAttribute("userid", id);
							check = 0;
						}else {	//비밀번호 틀린경우
							check = -1;
						}
					}
				} else { 			// 회원정보가 DB에 존재하지 않을 경우
					check = -2;
				}
				
				
				 	request.setAttribute("check", check);
				    ActionForward forward = new ActionForward();
				    forward.setRedirect(false);
				    forward.setPath("/WEB-INF/Register/re.jsp");
				    
				return forward;
	}

}
