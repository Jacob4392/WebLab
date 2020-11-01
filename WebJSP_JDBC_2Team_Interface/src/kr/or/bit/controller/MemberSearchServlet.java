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

@WebServlet("/MemberSearchServlet")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSearchServlet() {
        super();
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 검색하고자 하는 아이디 : search parameter
		String search = request.getParameter("search");

		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		try {
			memberdao dao = new memberdao();
			List<koreamember> memberlist = null;
			
			// DB에 검색한 id정보가 하나 이상 있다면 rowcount > 0
			int rowcount = dao.countMember(search);
			
			// 검색 후 반환된 row가 있다면 : like검색으로 Multi row 반환하여 list에 저장
			if(rowcount > 0) memberlist = dao.searchMember(search);
			request.setAttribute("memberlist", memberlist);
			request.setAttribute("countmember", rowcount);
			request.setAttribute("search", search);
			
			RequestDispatcher dis = request.getRequestDispatcher("Ex03_MemberSearch.jsp");
			
			dis.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<script>");
				out.print("alert('재시도 해주세요');");
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