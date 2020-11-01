package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws IOException, ServletException {
    	// 1. 한글처리
    	request.setCharacterEncoding("UTF-8");
    	
    	// 2. 요청값 받기
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	String mname = request.getParameter("mname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String gender = request.getParameter("gender");
    	String email = request.getParameter("email");
    	String ip =  request.getRemoteAddr();
    	
		response.setContentType("text/html;charset=UTF-8"); // 정보를 알려주는것
		try {
			// 3. 요청에 대한 처리
			memberdao dao = new memberdao();
			
			PrintWriter out = response.getWriter();
			
			if(dao.findById(id) != null) {	
				out.print("<script>");
	    			out.print("alert('이미 존재하는 아이디입니다. 다시 회원가입 해주세요.');");
	    			out.print("location.href='Ex02_JDBC_JoinForm.jsp';");		// 다시 요청하는 것
	    		out.print("</script>");
			} else {
				int rowcount = 0;
				rowcount = dao.insertAccount(new koreamember(id, pwd, mname, age, gender, email, ip));
				
				if(rowcount > 0) {
					out.print("<script>");
						out.print("alert('가입이 완료되었습니다. 로그인을 해주세요.');");
						out.print("location.href='Ex02_JDBC_Login.jsp';");
					out.print("</script>");
			    }else {	// 어떤 경우인지?
			    	out.print("<script>");
			    		out.print("alert('등록 실패.. 다시 회원가입 화면으로 돌아갑니다.')");
			    		out.print("location.href='Ex02_JDBC_JoinForm.jsp';");
					out.print("</script>");
			    }
			}
			//RequestDispatcher dis = request.getRequestDispatcher(viewpage);

			//5.정보를 request객체에 담아 forward로 전달
	    	//dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "Get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response, "Post");
	}

}
