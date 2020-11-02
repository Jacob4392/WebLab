package kr.or.bit.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class Edit implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");

		memberdao dao = new memberdao();
		try {
			
			koreamember km = dao.selectAccount(id);
			
			response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
			
			request.setAttribute("koreamember", km);
			
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/Ex03_MemberEdit.jsp");
			
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		return null;
	}	

	
}
