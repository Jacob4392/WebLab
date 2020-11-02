package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/Encoding")
public class Encoding implements Filter {

	//변수 만들기(전역변수)
	private String encoding;

    public Encoding() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		//최초 요청시 컴파일되고 한 번만 실행됩니다.(코드가 수정되거나, 서버가 재실행할 떄 실행됩니다)
		//FilterConfig => web.xml에서 설정한 변수값을 읽을 수 있습니다.
		this.encoding = fConfig.getInitParameter("encoding");//전역변수로 설정한 값을 parameter로 설정할 수 있습니다.
		System.out.println("Filter init 함수 실행: " + this.encoding);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//request 요청이 오면 실행되는 코드
		if(request.getCharacterEncoding() == null) {
			System.out.println("before: " + request.getCharacterEncoding());
			//한 줄의 코드(공통 관심, 보조 관심)
			request.setCharacterEncoding(this.encoding);
			//
			System.out.println("after: " + request.getCharacterEncoding());
		}
		//
		chain.doFilter(request, response);//다음 필터가 있으면 그 필터를 실행하겠다는 의미입니다.
		//response 응답처리 실행코드
			System.out.println("응답 처리 실행");
		//
		
	}




}
