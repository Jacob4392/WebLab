package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;

public class DeleteService implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		 ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/Ex02_JDBC_Main.jsp");
		    
		   
		
		if(id.equals("admin")) {	// 관리자가 자기 자신을 삭제 못하도록...
			System.out.println("관리자 자기자신 삭제 X");
			 return forward;
		}
		
		try {
			memberdao dao = new memberdao();

			int rowcount = dao.deleteMember(id);
			
			if(rowcount > 0) {
				System.out.println("정상삭제");
				//정상삭제
			}else {
				System.out.println("삭제안됨");
				//삭제안됨
			}
			
			
			
		} catch (Exception e) {
			System.out.println("삭제안됨");
			//삭제안됨
		}
	    	
	    	
	    
		 return forward;
		   
			
			
		}
	}
