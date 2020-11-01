package kr.or.bit.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class signUpService implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    	
    	// 2. 요청값 받기
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	String mname = request.getParameter("mname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String gender = request.getParameter("gender");
    	String email = request.getParameter("email");
    	String ip =  request.getRemoteAddr();
    	
    	String check = "";
		try {
			// 3. 요청에 대한 처리
			memberdao dao = new memberdao();
			
			if(dao.findById(id) != null) {	
				//이미 존재하는 id
				
				check = "false";
				System.out.println("이미 존재하는 id");
			} else {
				int rowcount = 0;
				System.out.println(gender);
				rowcount = dao.insertAccount(new koreamember(id, pwd, mname, age, gender, email, ip));
				
				if(rowcount > 0) {
					check = "true";
					System.out.println("가입완료");
				//가입 완료
			    }else {	// 어떤 경우인지?
			    	//?
			    	check = "error";
			    	System.out.println("예외 상황");
			    }
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		request.setAttribute("check", check);
	    ActionForward forward = new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("/Ex02_JDBC_Main.jsp");
	    
	    return forward;
	}

}
