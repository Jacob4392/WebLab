package kr.or.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.dao.memodao;
import kr.or.bit.dto.memo;


@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemoList() {
        super();
       
    }
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 select .... view 보내는 것 까지 .....
		//view 단 페이지 별도 구성 (과제 ....) >> memolist.jsp 
		try {
			 //요청 판단 ... 필요없다 (요청당 servlet 1개씩 ...)
			 //이 servlet 전체조회 ....
			 
			 memodao dao = new memodao();
			 List<memo> memolist = dao.getMemoList();
			 System.out.println("memolist : " + memolist);
			 //데이터 저장
			 request.setAttribute("memolist", memolist);
			 
			 //view 페이지 설정
			 RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
			 
			 //forward 
			 dis.forward(request, response); 
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
