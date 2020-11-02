package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//view 단 구성
		//글번호를 가지고 와서 
		int num =Integer.parseInt(request.getParameter("num"));
		BoardDao boarddao = new BoardDao();
		Board boarddata = new Board();
		
		boarddao.setReadCountUpdate(num);//조회수 증가
		boarddata =boarddao.getDetail(num);
		
		if(boarddata == null){
			System.out.println("Null Data 처리");
			return null;
		}
		System.out.println("boardbean Data 완료");
		//데이터 가지고 ...
		//view 페이지에서 처리되는 bean 객체
		
		request.setAttribute("boarddata",boarddata);
		System.out.println(">>>>>>"+request.toString());
		System.out.println("검증: " +request.getAttribute("gogo"));
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("qna_board_view.jsp");
		return forward;
	
	}

}
