package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		boolean result = false;
		boolean userCheck = false;

		ActionForward forward = null;
		
		try {
			int num = Integer.parseInt(request.getParameter("BOARD_NUM"));

			BoardDao boarddao = new BoardDao();
			Board boarddata = new Board();
			userCheck = boarddao.isBoardWriter(num, request.getParameter("BOARD_PASS"));
			if (userCheck == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('수정할수 없다');");
				out.print("location.href='boardlist.do';");
				out.print("</script>");
				out.close();
				return null;

			}

			// 실수정 (글제목 , 글내용) => qna_board_Modify.jsp
			boarddata.setBoard_num(num);
			boarddata.setBoard_subject(request.getParameter("BOARD_SUBJECT"));
			boarddata.setBoard_content(request.getParameter("BOARD_CONTENT"));

			result = boarddao.boardModify(boarddata);

			if (result == false) {
				System.out.println("게시판 수정 실패");
				return null;
			}
			System.out.println("게시판 수정 성공");

			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("BoardDetailAction.do?num=" + boarddata.getBoard_num());
		} catch (Exception e) {
			System.out.println("[BoardModifyAction.java] 예외 발생 : " + e.getMessage() );
			e.printStackTrace();
		}
		return forward;
	}

}
