package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.koreamember;

public class EditService  implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				
				
				
				response.setContentType("text/html;charset=UTF-8");
				
				try {
					memberdao dao = new memberdao();
					
					int n = dao.updateMember(new koreamember(id,name,age,gender,email));
					if(n > 0) {
						System.out.println("수정완료");
					}else {
						System.out.println("수정 재시도 해주세요");
					}
				} catch (Exception e) {
					System.out.println("수정 재시도 해주세요");
				}

		
		
		 ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/Ex02_JDBC_Main.jsp");
		    return forward;
			
			
		}
	}