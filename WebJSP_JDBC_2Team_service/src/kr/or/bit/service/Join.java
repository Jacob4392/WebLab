package kr.or.bit.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.EmpDAO;

import kr.or.bit.dto.EmpDTO;

public class Join implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String uploadpath = request.getSession().getServletContext().getRealPath("upload");

		int size = 1024 * 1024 * 10; // 10M 네이버 계산기
		ActionForward forward = new ActionForward();
		String context = request.getContextPath();
		// output, input을 만들지 않아도됨, 좋음!!
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, // 기존에 있는 request 객체의 주소값
					uploadpath, // 실 저장 경로 (배포경로)
					size, // 10M
					"UTF-8", 
					new DefaultFileRenamePolicy() // 파일 중복(upload 폴더 안에:a.jpg -> a_1.jpg(업로드 파일 변경) )
			);
		} catch (IOException e1) {
			System.out.println("Join.java (kr.or.bit.service) MultipartRequest 도중 예외 발생 ::" + e1.getMessage());
			e1.printStackTrace();
		}

		try {
			int empno = Integer.parseInt(multi.getParameter("empno"));
			String ename = multi.getParameter("ename");
			String job = multi.getParameter("job");
			int mgr = Integer.parseInt(multi.getParameter("mgr"));
			String hiredate = multi.getParameter("hiredate");
			int sal = Integer.parseInt(multi.getParameter("sal").replaceAll(",", ""));
			int comm = Integer.parseInt(multi.getParameter("comm").replaceAll(",", ""));
			int deptno = Integer.parseInt(multi.getParameter("deptno"));

			Enumeration filenames = multi.getFileNames();

			String file = (String) filenames.nextElement();
			String filename = multi.getFilesystemName(file);
			if (filename == null) {
				filename = "emp.jpg";
			}

			EmpDAO dao = new EmpDAO();

			int rowcount = 0;
			try {
				rowcount = dao.insertAccount(new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno, filename));
			} catch (Exception e) {
				e.printStackTrace();
				rowcount = 0;
			}
			String msg = "";
			String url = "";
			if (rowcount > 0) {
				msg = "가입이 완료되었습니다. 로그인을 해주세요.";
				url = "ShowEmpList.member";
			} else {
				msg = "회원가입에 실패하였습니다. 다시 회원가입을 해주세요";
				url = "Joinform.member";
			}

			request.setAttribute("msg", msg);
			request.setAttribute("url", url);

			forward.setPath("/WEB-INF/views/redirect.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return forward;

	}
}
