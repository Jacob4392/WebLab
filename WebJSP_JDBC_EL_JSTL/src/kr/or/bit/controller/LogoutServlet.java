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


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
//		if(session.getAttribute("userid") == null || 
//				!session.getAttribute("userid").equals("admin")  
//				){
//				  //다른 페이지 이동
//				  out.print("<script>");
//				  out.print("location.href='Ex02_JDBC_Login.jsp'");
//				  out.print("</script>");
//				}
		out.print("<script>");
			out.print("alert('확인');");
		out.print("</script>");
		session.invalidate();
		response.sendRedirect("Ex02_JDBC_Login.jsp");
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"POST");
	}

}
