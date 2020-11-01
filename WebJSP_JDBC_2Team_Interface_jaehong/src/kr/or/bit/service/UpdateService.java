package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class UpdateService implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		// 2. 요청 받기
		String id = request.getParameter("id");

		memberdao dao = new memberdao();
		try {
			
			koreamember km = dao.selectAccount(id);
			
			response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
			
			request.setAttribute("koreamember", km);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		 ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/Register/Ex03_MemberEdit.jsp");
		    return forward;
			
			
		}
	}