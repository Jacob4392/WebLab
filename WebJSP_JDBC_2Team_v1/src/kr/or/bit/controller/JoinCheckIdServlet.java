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

import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;


@WebServlet("/JoinCheckIdServlet")
public class JoinCheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JoinCheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
		String id = request.getParameter("id");
		System.out.println("id(Ex02_JDBC_JoinForm -> JoinCheckIdServlet): "+id);
		memberdao dao = new memberdao();
		String ischeck = dao.isCheckById(id);
		
		out.print(ischeck);
		

		

		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"POST");
	}

}
