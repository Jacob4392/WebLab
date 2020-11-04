package kr.or.bit.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.AdminlistDAO;
import kr.or.bit.dao.memberdao;
import kr.or.bit.dto.AdminlistDTO;
import kr.or.bit.dto.koreamember;

public class LoginInput implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd"); // 브라우저페이지에서 사용자가 입력한 값

		AdminlistDAO dao = new AdminlistDAO();
		AdminlistDTO adm = dao.isExist(id);

		memberdao mdao = new memberdao();
		koreamember km = mdao.findById(id);

		String msg = "";
		String url = "";

		if (adm != null) {
			if (adm.getUserid().equals(id)) {
				if (adm.getPwd().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("userid", id);
					msg = "관리자 로그인 성공";
				} else {
					msg = "비밀번호가 틀립니다.";
				}
			}
		} else if (km != null) {
			if (km.getId().equals(id)) {
				if (km.getPwd().equals(pwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("userid", id);
					msg = "로그인 되셨습니다.";
				} else {
					msg = "비밀번호가 틀립니다.";
				}
			}
		} else {
			msg = "등록된 회원이 아닙니다.";
		}
		url = "Ex02_JDBC_Main.jsp";
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;

	}

}
