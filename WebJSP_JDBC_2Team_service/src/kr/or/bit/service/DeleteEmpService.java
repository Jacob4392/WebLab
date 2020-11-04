package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDAO;

public class DeleteEmpService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		EmpDAO dao = new EmpDAO();
		
		String msg = "";
		String url = "";
		int result = dao.deleteEmp(empno);
		System.out.println(result);
		
		if(result > 0) {
			msg = "정상 삭제되었습니다.";
		}else {
			msg = "삭제 실패.";
		}
		
		url="ShowEmpList.member";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/redirect.jsp");
		
		return forward;
		
	}
	
}
