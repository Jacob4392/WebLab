package kr.or.bit.service;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class Search implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String search = request.getParameter("search");

		String msg ="";
		String url ="";
		try {
			memberdao dao = new memberdao();
			List<koreamember> memberlist = null;
			
			// DB에 검색한 id정보가 하나 이상 있다면 rowcount > 0
			int rowcount = dao.countMember(search);
			
			// 검색 후 반환된 row가 있다면 : like검색으로 Multi row 반환하여 list에 저장
			if(rowcount > 0) memberlist = dao.searchMember(search);
			request.setAttribute("memberlist", memberlist);
			request.setAttribute("countmember", rowcount);
			request.setAttribute("search", search);
			
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/Ex03_MemberSearch.jsp");
			
			dis.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
				msg = "재시도 해주세요";
				url = "MemberList.member";
		}
		request.setAttribute("board_msg",msg);
	    request.setAttribute("board_url", url);
	
	    ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/WEB-INF/views/redirect.jsp");
	
	return forward;
		
	}
	
}
