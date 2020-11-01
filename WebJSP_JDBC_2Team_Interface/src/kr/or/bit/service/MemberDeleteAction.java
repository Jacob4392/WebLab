package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;

public class MemberDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
		if(session.getAttribute("userid") == null || 
				!session.getAttribute("userid").equals("admin")  
				){
				  //다른 페이지 이동
				  out.print("<script>");
				  out.print("alert('권한이 없거나 세션이 만료되었습니다.');");
				  out.print("location.href='Ex02_JDBC_Login.jsp'");
				  out.print("</script>");
				}
		
		String id = request.getParameter("id");

		if(session.getAttribute("userid").equals(id)) {	// 관리자가 자기 자신을 삭제 못하도록...
			out.print("<script>");
				out.print("alert('나쁜 생각 하지 말아요...');");
				out.print("location.href='MemberList.do'");
			out.print("</script>");
			System.out.println("관리자 자기자신 삭제 X");
			return null;
		}
		
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
		
		try {
			memberdao dao = new memberdao();

			int rowcount = dao.deleteMember(id);
			
			if(rowcount > 0) {
				out.print("<script>");
					out.print("alert('정상적으로 삭제되었습니다');");
			}else {
				out.print("<script>");
					out.print("alert('삭제되지 않았습니다');");
			}
			forward.setPath("/MemberList.do");
			//out.print("location.href='MemberListServlet'");
			out.print("</script>");
			
		} catch (Exception e) {
			forward.setPath("/MemberList.do");
			out.print("<script>");
				out.print("alert('삭제되지 않았습니다~');");
				//out.print("location.href='MemberListServlet'");
			out.print("</script>");
		}
		return forward;
	}
}
