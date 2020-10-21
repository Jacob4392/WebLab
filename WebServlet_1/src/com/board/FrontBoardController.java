package com.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.CommandAPDU;


//@WebServlet("/FrontBoardController")
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    //컨트롤러에 요청이 들어오면 GET, POST 두가지 요청에 대해서 동작하는 함수
    //doGet, doPost가 자동호출 됩니다.
    //이외에 개발자가 사용자함수를 만들어 호출할 수 있습니다.
    //1.별도의 사용자 함수를 만들어서 사용 : doProcess
    //doGet, doPost가 호출되면 doProcess에 위임하도록
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		//doGet 요청, doPost 요청 모두 처리하겠다
		System.out.println("클라이언트 요청함수: " + method);

		//1.한글 처리
		//2.요청받기(request)
		//3.요청판단(판단의 기준은? 1:parameter를 기준, command 방식) : 서비스를 만든다는 의미
		//3.1 command 방식 parameter를 기준으로  판단하는 방식 
		//3.2 http://192.168.0.8:8090/WebServlet_1/board?cmd=login&id=jgdoh&pwd=1004 //로그인
		//3.3 http://192.168.0.8:8090/WebServlet_1/board?cmd=list //게시판을 보여준다고 판단
		//command에 대한 처리값을 사전에 만들어주어야 합니다.
		
		String str = request.getParameter("cmd");
		//ex) if(command.equals("login")) {로그인 처리 서비스}
		//else if(command.equals("list")){게시판 목록보기 서비스}
		
		
		//command 방식과 함께 쓰이는 방식
		//*3.4 URL주소 방식 (더 많이 사용하는 방식)
		//http://192.168.0.8:8090/WebServlet_1/board/boardlist
		//http://192.168.0.8:8090/WebServlet_1/board/boardwrite?title=아무개&content=방가방가
		
		//마지막 주소값을 추출합니다 : /boardlist 문자열이면 >> 게시판 목록보기
		//					 /boardwrite 문자열이면 >> 게시판에 글쓰기
		
		//4.결과를 저장합니다(request, session, application) 로그인한 아이디는 주로 session으로 저장
		
		//5.view 지정합니다(MVC패턴 기준)
		//view page 지정: jsp
		//WebContent > board > boardlist.jsp
		//WebContent > error > error404.jsp (Dispatcher)
		
		//위 코드는 보안상의 문제가 있습니다.(WebContent에 만들면 안됨)
		//WebContent >> 아래의 자원은 클라이언트가 직접요청할 수 있습니다.
		//그런데 직접 요청해서는 안되는 자원이 대부분입니다..
		//해결방법은?
		//해결: 보안폴더를 사용합니다: WEB-INF >> views >> board >> boardlist.jsp
		//but, WAS 내부에서는 서로 접근이 가능합니다. forward 처리를 통해서(서버코드를 read,출력합니다)
		
		//6. view에게 저장된 객체를 전달합니다(forward) (모든 프로그램은 연결되어 있다)
	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
