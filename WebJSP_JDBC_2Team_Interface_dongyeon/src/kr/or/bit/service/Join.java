package kr.or.bit.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class Join implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	String mname = request.getParameter("mname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String gender = request.getParameter("gender");
    	String email = request.getParameter("email");
    	String ip =  request.getRemoteAddr();
		
    	memberdao dao =new memberdao();
    	
    	String msg ="";
    	String url ="";
    	
    		int rowcount = 0;
    	rowcount = dao.insertAccount(new koreamember(id, pwd, mname, age, gender, email, ip));
    	
    	if(rowcount > 0 ) {
    		msg="가입이 완료되었습니다. 로그인을 해주세요.";
    		url="Login.member";
    	}else {
    		msg="회원가입에 실패하였습니다. 다시 회원가입을 해주세요";
    		url="Joinform.member";
    	}

    	request.setAttribute("board_msg",msg);
	    request.setAttribute("board_url", url);
	
	    ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/WEB-INF/views/redirect.jsp");
	    
	    return forward;
	

}
}
