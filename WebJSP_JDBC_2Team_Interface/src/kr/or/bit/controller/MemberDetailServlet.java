package kr.or.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;


@WebServlet("/MemberDetailServlet")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDetailServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String id = request.getParameter("id");
    	
		try {
			memberdao dao = new memberdao();
	    	koreamember dto = dao.selectAccount(id);
	    	
			request.setAttribute("member", dto);
			
			RequestDispatcher dis = request.getRequestDispatcher("Ex03_MemberDetail.jsp");
			
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
