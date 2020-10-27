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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
		try {
			memberdao dao = new memberdao();
			koreamember kmember = dao.getListById(id);
			
			if(pwd.equals(kmember.getPwd())) {
				session.setAttribute("userid", kmember.getId());
				out.print("<script>");
					out.print("alert('로그인완료');");
					//response.sendRedirect("Ex02_JDBC_Main.jsp");
					out.print("location.href='Ex02_JDBC_Main.jsp'");
				out.print("</script>");

			}else {
				out.print("<script>");
					out.print("location.href='Ex02_JDBC_Login.jsp'");
				out.print("</script>");
			}
			
			
			
		} catch (Exception e) {
			out.print("<script>");
				out.print("alert('다시 로그인을 시도해 해주세요');");
				out.print("location.href='Ex02_JDBC_Login.jsp'");
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
