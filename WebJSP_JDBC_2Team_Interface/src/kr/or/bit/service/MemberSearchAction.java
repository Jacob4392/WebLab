package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class MemberSearchAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 검색하고자 하는 아이디 : search parameter
		String search = request.getParameter("search");

		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	
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
			
			forward.setPath("/WEB-INF/Member/Ex03_MemberSearch.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
			forward.setPath("/MemberList.do");
			out.print("<script>");
				out.print("alert('재시도 해주세요');");
				//out.print("location.href='Ex03_Memberlist.jsp'");
			out.print("</script>");
		}
		return forward;
	}
}
