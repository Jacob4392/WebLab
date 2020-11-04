package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardModifyView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int num =Integer.parseInt(request.getParameter("num"));
		BoardDao boarddao = new BoardDao();
		Board boarddata = new Board();
		boarddata =boarddao.getDetail(num);
		if(boarddata == null){
			System.out.println("수정 상세보기 실패");
			return null;
		}
		System.out.println("수정 상세보기 성공");
		
		//key point
		//why qna_board_modify.jsp 
		// request.getAttribute("boarddata") 데이터를 받는다
		request.setAttribute("boarddata", boarddata);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("WEB-INF/views/Board_Modify.jsp");
		return forward;
		
		
	}

}
