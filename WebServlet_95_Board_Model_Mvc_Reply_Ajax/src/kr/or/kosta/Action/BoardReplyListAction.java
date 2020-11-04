package kr.or.kosta.Action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.dao.boarddao;
import kr.or.kosta.dto.reply;
import net.sf.json.JSONArray;

public class BoardReplyListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("replylist들어옴");
		String idx = request.getParameter("idx");
		String ps = request.getParameter("ps");
		String cp = request.getParameter("cp");
		List<reply> replylist = null;
		JSONArray jsonarray=null;
		try {
			boarddao dao = new boarddao();
			replylist = dao.replylist(idx);
			jsonarray = JSONArray.fromObject(replylist);
			request.setAttribute("jsonarray", jsonarray);
		}catch(Exception e) {
			System.out.println("에러뜬다");
		}finally {
			
		}
		//ActionForward forward = new ActionForward();
		//forward.setPath("/board/replyjson.jsp");
		//return forward;
		PrintWriter out = response.getWriter();
		out.print(jsonarray);
		return null;
	}

}
