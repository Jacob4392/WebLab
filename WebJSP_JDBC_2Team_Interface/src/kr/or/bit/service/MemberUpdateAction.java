package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class MemberUpdateAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 요청 받기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			memberdao dao = new memberdao();
			
			int n = dao.updateMember(new koreamember(id,name,age,gender,email));
			if(n > 0) {
				forward.setPath("/MemberList.do");

				out.print("<script>");
					out.print("alert('수정이 완료되었습니다');");
					//out.print("location.href='MemberListServlet'");
				out.print("</script>");
			}else {
				forward.setPath("/MemberEdit.do");
				out.print("<script>");
					out.print("alert('수정을 재시도 해주세요');");
				out.print("</script>");
			}
		} catch (Exception e) {
			forward.setPath("/MemberEdit.do");
			out.print("<script>");
				out.print("alert('수정을 재시도 해주세요');");
				//out.print("location.href='MemberListServlet'");
			out.print("</script>");
		}
		return forward;
	}
}
