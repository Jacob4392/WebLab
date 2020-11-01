package kr.or.bit.controller;

import java.io.IOException;
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

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberListServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	// 조건에 따라 세션 인밸리데이트 해야함
    	HttpSession session = request.getSession();
    	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
    		session.invalidate();
    		response.sendRedirect("Ex02_JDBC_Main.jsp");
    	}
    	
    	memberdao dao = new memberdao();
    
		try {
			List<koreamember> memberList = dao.getDAOAllList();
			request.setAttribute("memberList", memberList);
			
			response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
			
			RequestDispatcher dis = request.getRequestDispatcher("Ex03_Memberlist.jsp");
			
			dis.forward(request, response);
		}catch (Exception e) {
			System.out.println("관리자 회원목록 불러오기 중 오류 발생 : " + e.getMessage());
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Post");
	}

}
