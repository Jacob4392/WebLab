package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class BoardListAction implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boarddao = new BoardDao();
		
		List boardlist = new ArrayList();
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = boarddao.getListCount();
		boardlist = boarddao.getBoardList(page, limit);
		
		int maxpage = (int)((double) listcount / limit + 0.95);
		
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		
		int endpage = startpage + 10 - 1;
		
		if(endpage > maxpage) {
			endpage = maxpage;
		}
		
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("boardlist", boardlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("WEB-INF/views/Board_List.jsp");
		//forward.setPath("qna_board_list_jqgrid.jsp");
		return forward;
	}
}
