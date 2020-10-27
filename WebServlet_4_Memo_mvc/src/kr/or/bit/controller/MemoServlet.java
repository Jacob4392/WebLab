package kr.or.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;


@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		//http://192.168.0.169:8090/WebServlet_4_Memo_mvc/MemoServlet
		//이 서블릿은 하나의 요청(/MemoServlet)만 처리하도록 만듬: insert command방식, url방식을 통한 판단이 필요 없습니다.
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String content = request.getParameter("memo");
		
		//UI or UX
		//글의 처리가 완료된 페이지는 필요가 없음
		//insert 처리하는 
		//성공여부 처리는 어떻게?
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //out객체를 response로부터 얻어냄
		
		try {
			//DAO단 //key Point 통제의 역할
			memodao dao = new memodao();
			int n = dao.insertMemo(new memo(id,email,content));
			//클라이언트에게서 받은 데이터를 생성자를 통해 객체를 만들어서 넣어줍니다
			
			if(n > 0) {
				out.print("<script>");
					out.print("alert('등록성공');");
					out.print("location.href='MemoList';");
					//http://192.168.0.169:8090/WebServlet_4_Memo_mvc/MemoList
				out.print("</script>");
			}else {
				out.print("<script>");
					out.print("alert('등록실패');");
					out.print("location.href='memo.html';");
					//http://192.168.0.169:8090/WebServlet_4_Memo_mvc/MemoList
				out.print("</script>");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response,"POST");
	}

}
