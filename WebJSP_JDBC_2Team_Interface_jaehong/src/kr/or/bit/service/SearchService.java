package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;

public class SearchService implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String search = request.getParameter("search");

		try {
			memberdao dao = new memberdao();
			String check = dao.IdIsExist(search);//있으면 String true 없으면 false
			request.setAttribute("check", check);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/Register/SearchHelper.jsp");
		    return forward;
		}
	}
