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
import kr.or.bit.dto.koreamember;


@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("mname");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String ip = request.getRemoteAddr();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
		try {
			memberdao dao = new memberdao();
			int n = dao.insertMember(new koreamember(id,pwd,name,age,gender,email,ip));
			
			if(n > 0) {
				out.print("<script>");
					out.print("alert('가입완료');");
					out.print("location.href='Ex02_JDBC_Login.jsp'");
				out.print("</script>");
			}else {
				out.print("<script>");
					out.print("alert('가입 재시도 해주세요');");
				out.print("</script>");
			}
			
		} catch (Exception e) {
			out.print("<script>");
				out.print("alert('가입을 재시도 해주세요');");
				out.print("location.href='Ex02_JDBC_JoinForm.jsp'");
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
