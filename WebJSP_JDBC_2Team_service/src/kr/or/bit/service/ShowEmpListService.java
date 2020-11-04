package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDAO;
import kr.or.bit.dto.EmpDTO;

public class ShowEmpListService implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		EmpDAO dao = new EmpDAO();
		
		String ps = request.getParameter("ps");		// 클라이언트로부터
		String cp = request.getParameter("cp");		// 보고싶은 글 수와 현재 페이지 번호를 받아옴
		
		if(ps == null || ps.trim().equals("")) {	// ps값이 없는 경우 기본 페이지 크기 지정
			ps = "5";
		}
		if(cp == null || cp.trim().equals("")) {	// cp값이 없는 경우 현재 페이지 지정
			cp = "1";
		}
		
		int pagesize = Integer.parseInt(ps);
		int currpage = Integer.parseInt(cp);
		int totalcount = dao.getEmpAllCount();
		int pagecount = 0;
		
		if (totalcount % pagesize == 0) {
			pagecount = totalcount / pagesize;
		} else {
			pagecount = (totalcount / pagesize) + 1;
		}
		List<EmpDTO> emplist = dao.getPagedEmpList(currpage, pagesize);
		
		request.setAttribute("emplist", emplist);		// 순번에 따른 멤버 출력
		request.setAttribute("pagesize", pagesize);		// 출력할 글 수(명수)
		request.setAttribute("pagecount", pagecount);	// 
		request.setAttribute("currpage", currpage);		// 
		
		forward.setPath("/WEB-INF/views/EmpList.jsp");
		return forward;
	}
}
