package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.dao.memberdao;

@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberDeleteServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
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
				out.print("location.href='MemberListServlet'");
			out.print("</script>");
			System.out.println("관리자 자기자신 삭제 X");
			return;
		}
		
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
			
					out.print("location.href='MemberListServlet'");
				out.print("</script>");
			
		} catch (Exception e) {
			out.print("<script>");
				out.print("alert('삭제되지 않았습니다~');");
				out.print("location.href='MemberListServlet'");
			out.print("</script>");
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"POST");
	}

}
