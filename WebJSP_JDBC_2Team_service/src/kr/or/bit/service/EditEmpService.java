package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDAO;
import kr.or.bit.dto.EmpDTO;

public class EditEmpService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 요청 받기
		int empno = Integer.parseInt(request.getParameter("empno"));
		
		// 요청 받은 empno 검색 후 emp에 저장
		EmpDAO dao = new EmpDAO();
		EmpDTO emp = dao.getDetailEmp(empno);
		
		request.setAttribute("emp", emp);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/views/EditEmp.jsp");
		
		return forward;
	}
}
