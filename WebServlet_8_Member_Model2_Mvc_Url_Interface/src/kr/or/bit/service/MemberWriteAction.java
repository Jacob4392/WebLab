package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MvcRegisterDao;
import kr.or.bit.dto.MvcRegister;

//회원정보를 write 서비스
//실행하는 함수 : execute
public class MemberWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//controller 작업 내용
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		//controller -> service 객체 처리
		//dao , dto 처리
		
		MvcRegister dto = new MvcRegister();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		MvcRegisterDao dao = new MvcRegisterDao();
		int result = dao.writeOk(dto);
		
		String resultdata="";
		if(result > 0) {
			resultdata ="welcome to bit " + dto.getId() + "님";
		}else {
		   resultdata = "Insert Fail retry";
		}
		
		//3. 결과 저장하기 
		request.setAttribute("data", resultdata);
		//viewpage = "/WEB-INF/Register/Register_welcome.jsp";
		
		//ActionForward >> memberfield
		//private boolean isRedirect = false; //화면 아니면 로직 제어 
		//private String path=null; //이동경로 (뷰의 주소)
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/Register/Register_welcome.jsp");
		return forward;
	}

}





