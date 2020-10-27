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


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		if(session.getAttribute("userid") == null || 
				!session.getAttribute("userid").equals("admin")  
				){
				  //다른 페이지 이동
				  out.print("<script>");
				  out.print("location.href='Ex02_JDBC_Login.jsp'");
				  out.print("</script>");
				}
		
		request.setCharacterEncoding("UTF-8");

		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		

		
		try {
			memberdao dao = new memberdao();
			int n = dao.updateMember(new koreamember(id,name,age,gender,email));
			
			if(n > 0) {
				out.print("<script>");
					out.print("alert('수정이 완료되었습니다');");
					out.print("location.href='Ex03_Memberlist.jsp'");
				out.print("</script>");
			}else {
				out.print("<script>");
					out.print("alert('수정을 재시도 해주세요');");
				out.print("</script>");
			}
			
		} catch (Exception e) {
			out.print("<script>");
				out.print("alert('수정을 재시도 해주세요');");
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
