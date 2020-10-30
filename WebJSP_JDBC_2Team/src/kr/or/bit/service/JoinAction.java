package kr.or.bit.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class JoinAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	String mname = request.getParameter("mname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String gender = request.getParameter("gender");
    	String email = request.getParameter("email");
    	String ip =  request.getRemoteAddr();
		
//    	koreamember dto = new koreamember();
//    	dto.setId(id);
//    	dto.setPwd(pwd);
//    	dto.setName(mname);
//    	dto.setAge(age);
//    	dto.setGender(gender);
//    	dto.setEmail(email);
//    	dto.setIp(ip);
    	
    	memberdao dao = new memberdao();
    	
    	ActionForward forward = new ActionForward();
    	forward.setRedirect(false);
    	
    	if(dao.findById(id) != null) {
    		forward.setPath("/WEB-INF/Register/Ex02_JDBC_JoinForm.jsp");
    		out.print("<script>");
				out.print("alert('이미 존재하는 아이디입니다. 다시 회원가입 해주세요.');");
				//out.print("location.href='Join.do';");	// 다시 요청하는 것
			out.print("</script>");
    	}else {
    		int rowcount = 0;
    		rowcount = dao.insertAccount(new koreamember(id, pwd, mname, age, gender, email, ip));
    		
    		if(rowcount > 0) {
    			forward.setPath("/WEB-INF/Register/Ex02_JDBC_Login.jsp");
				out.print("<script>");
					out.print("alert('가입이 완료되었습니다. 로그인을 해주세요.');");
					//out.print("location.href='Login.do';");
				out.print("</script>");
    		}else {
    			forward.setPath("/WEB-INF/Register/Ex02_JDBC_JoinForm.jsp");
		    	out.print("<script>");
	    			out.print("alert('등록 실패.. 다시 회원가입 화면으로 돌아갑니다.')");
	    			//out.print("location.href='Join.do';");
	    		out.print("</script>");
    		}
    		
    	}
    	return forward;
	}
}
