package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.CustomerController;

//annotation대신 web.xml 작성
//client의 모든 요청이 처음에 들어오는 front controller
public class CustomerFilter implements Filter {	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest)request;	
			HttpServletResponse res = (HttpServletResponse)response;
			
			req.setCharacterEncoding("euc-kr");
			
			//클라이언트로부터 들어온 요청을 구분해서 Controller에게 작업 지시
			// url 값에서 맨뒷부분의 글자 알아냄 getServletPath(): /list.cus, /read.cus ....

			//http://localhost:8080/customer/list.cus  : 클라이언트가 할 요청
			//			서버:port/Context_Root/Servlet_Path
			String reqString = req.getServletPath();
			//System.out.println(reqString);
			
			CustomerController cc = new CustomerController();
			
			if(reqString.equals("/list.cus")){				
				cc.list(req, res);
				
			}else if(reqString.equals("/read.cus")){
				cc.read(req, res);
				
			}else if(reqString.equals("/insert.cus") ){
				cc.insertForm(req, res);
				
			}else if(reqString.equals("/insertProcess.cus")){
				cc.insert(req,  res);
				
			}else if(reqString.equals("/delete.cus")){
				cc.delete(req,  res);
				
			}				
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}

}





