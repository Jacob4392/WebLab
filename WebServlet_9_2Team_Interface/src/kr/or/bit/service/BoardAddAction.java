package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardAddAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao boarddao = new BoardDao();
		Board boarddata = new Board();
		
		String realFolder = "";
		String saveFolder = "boardUpload";
		int filesize = 10 * 1024 * 1024; //10M
		realFolder = request.getSession().getServletContext()
					.getRealPath(saveFolder);
		
		boolean result = false;
		try {
			//MultipartRequest type의 multi 객체 초기화 설정
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, 
					realFolder,
					filesize,
					"utf-8",
					new DefaultFileRenamePolicy()
			);
			
			boarddata.setBoard_pass(multi.getParameter("BOARD_PASS"));
			boarddata.setBoard_subject(multi.getParameter("BOARD_SUBJECT"));
			boarddata.setBoard_content(multi.getParameter("BOARD_CONTENT")
						.replace("/r/n", "<br>"));
			boarddata.setBoard_file(multi.getFilesystemName((String)multi
						.getFileNames().nextElement()));
			boarddata.setBoard_name(multi.getParameter("BOARD_NAME"));
			boarddata.setNotice(multi.getParameter("notice"));
			
			result = boarddao.boardInsert(boarddata);
			if(result == false) {
				System.out.println("Insert Fail");
				return null;
			}
			System.out.println("Insert Success");
			
			ActionForward forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("boardlist.do");
			return forward;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
