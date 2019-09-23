package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.BoardController;

//@WebFilter("/BoardFilter")
public class BoardFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		req.setCharacterEncoding("euc-kr");
		
		String reqString = req.getServletPath();
		BoardController bc = new BoardController();
		
		if(reqString.equals("/list.bod")) {
			bc.list(req,res);
			
		}else if(reqString.equals("/read.bod")) {
			bc.detail(req,res);
			
		}else if(reqString.equals("/insertForm.bod")) {
			bc.insertForm(req,res);
			
		}else if(reqString.equals("/insertProcess.bod")) {
			bc.insertSuccess(req,res);
			
		}else if(reqString.equals("/search.bod")) {
			bc.search(req,res);
			
		}else if(reqString.equals("/delete.bod")) {
			bc.delete(req,res); //삭제 후 처음으로 돌아오기
			
		}else if(reqString.equals("/read2.bod")) {
			bc.detail2(req,res);
			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}

}
