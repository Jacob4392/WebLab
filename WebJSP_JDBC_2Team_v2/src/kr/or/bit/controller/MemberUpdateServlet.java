package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 요청 받기
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		try {
			memberdao dao = new memberdao();
			
			int n = dao.updateMember(new koreamember(id,name,age,gender,email));
			if(n > 0) {
				out.print("<script>");
					out.print("alert('수정이 완료되었습니다');");
					out.print("location.href='MemberListServlet'");
				out.print("</script>");
			}else {
				out.print("<script>");
					out.print("alert('수정을 재시도 해주세요');");
				out.print("</script>");
			}
		} catch (Exception e) {
			out.print("<script>");
				out.print("alert('수정을 재시도 해주세요');");
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
