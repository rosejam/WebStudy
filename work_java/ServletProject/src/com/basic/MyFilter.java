package com.basic;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "/MyFilter",
urlPatterns = {"/Hello", "/MessageServlet"}) //클라이언트로 부터 어떤 url요청이 발생했을 경우 필터를 적용시킬지를 적어준다.
public class MyFilter implements Filter { //Filter인터페이스를 implements해야 필터가 된다.

    public MyFilter() {
    	System.out.println("filter 생성자");
    }
    
	public void destroy() {
		
	}
	
	//필터의 작업 내용을 가진 메소드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전 작업 내용(서블릿으로 request가 전달되기 전)
		System.out.println("filter...before");
		
		chain.doFilter(request, response); //연결된 다음 필터 또는 서블릿으로 요청을 전달~
		
		//사후 작업 내용(서블릿 실행  후 response에 작업)
		System.out.println("filter...after");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
