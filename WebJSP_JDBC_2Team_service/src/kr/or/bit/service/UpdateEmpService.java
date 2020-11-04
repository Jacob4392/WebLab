package kr.or.bit.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDAO;
import kr.or.bit.dto.EmpDTO;

public class UpdateEmpService implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = new ActionForward();
		// 파일 들어오면 추가
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		String hiredate = request.getParameter("hiredate");
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = Integer.parseInt(request.getParameter("comm"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		EmpDTO emp = new EmpDTO();
		
		emp.setEmpno(empno);
		emp.setEname(ename);
		emp.setJob(job);
		emp.setMgr(mgr);
		emp.setHiredate(hiredate);
		emp.setSal(sal);
		emp.setComm(comm);
		emp.setDeptno(deptno);
		
		EmpDAO dao = new EmpDAO();
		
		String msg = "";
		String url = "";
		
		if(dao.updateEmp(emp) > 0) {
			msg = emp.getEname()+" 정보 수정이 완료되었습니다.";
			url = "ShowEmpList.member";
		}else {
			msg = "Update Failed";
			url = "EditEmp.member?empno="+emp.getEmpno();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		forward.setPath("/WEB-INF/views/redirect.jsp");
		
		return forward;
	}
}
