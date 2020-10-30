package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
	}

	// 현재 LoginServlet은 로그인의 Process만을 담당한다.
	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method)
			throws ServletException, IOException {
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//2. 요청값 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd"); // 브라우저페이지에서 사용자가 입력한 값

		//3. 요청에 대한 서비스 로직 : 로그인
		response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
		PrintWriter out = response.getWriter();
		
		memberdao m = new memberdao();
		koreamember km = m.isExist(id);

		if (km != null) { 	// 회원정보가 존재할 경우
			if (km.getId().equals(id)) {
				if(km.getPwd().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("userid", id);
					response.sendRedirect("Ex02_JDBC_Main.jsp");
				}else {
					out.print("<script>");
					out.print("alert('비밀번호가 틀렸습니다.');");
					out.print("location.href='Ex02_JDBC_Login.jsp';");
					out.print("</script>");
				}
			}
		} else { 			// 회원정보가 DB에 존재하지 않을 경우
			out.print("<script>");
			out.print("alert('등록된 회원이 아닙니다.');");
			out.print("location.href='Ex02_JDBC_Main.jsp';");
			out.print("</script>");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response, "Get 방식으로 넘어왔음");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response, "Post 방식으로 넘어왔음");
	}

}
