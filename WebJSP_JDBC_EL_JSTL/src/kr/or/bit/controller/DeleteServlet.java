package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
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
				  out.print("location.href='Ex02_JDBC_Login.jsp'");
				  out.print("</script>");
				}
		
		String id = request.getParameter("id");
		
		try {
			memberdao dao = new memberdao();
			List<koreamember> memberlist = dao.getMemberList();
			for(koreamember m : memberlist) {
				//if(m.getId()
			}
			int rowcount = dao.deleteMember(id);
			
			if(rowcount > 0) {
				//view 페이지 지정하기
				RequestDispatcher dis = request.getRequestDispatcher("/Ex03_MemberDelete.jsp");
				dis.forward(request, response);

			}else {
				out.print("<script>");
					out.print("alert('삭제되지 않았습니다');");
					out.print("location.href='Ex03_Memberlist.jsp'");
				out.print("</script>");
			}
			
			
			
		} catch (Exception e) {
			out.print("<script>");
				out.print("alert('삭제되지 않았습니다~');");
				out.print("location.href='Ex03_Memberlist.jsp'");
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
