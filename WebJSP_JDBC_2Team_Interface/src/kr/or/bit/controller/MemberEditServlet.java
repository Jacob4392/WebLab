package kr.or.bit.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

@WebServlet("/MemberEditServlet")
public class MemberEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberEditServlet() {
        super();
    }
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 요청 받기
		String id = request.getParameter("id");

		memberdao dao = new memberdao();
		try {
			
			koreamember km = dao.selectAccount(id);
			
			response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
			
			request.setAttribute("koreamember", km);
			
			RequestDispatcher dis = request.getRequestDispatcher("Ex03_MemberEdit.jsp");
			
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"GET");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"POST");
	}
}