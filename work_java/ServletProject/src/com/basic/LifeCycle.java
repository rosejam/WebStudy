package com.basic;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet { //서블릿의 생명주기 테스트 init() & destroy()
	
	//서블릿이 어떤 클라이언트에게 맨 처음으로 호출되어서 메모리에 로드 될 때 딱 1번만 자동으로 호출 (서비스 메서드 실행 전에 초기화 등 "준비" 작업을 하는 메소드)
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method...");
	}
	
	//메모리에 올라와 있던 서블릿이 언로딩되기 전에 마지막으로 1번 자동으로 호출되어 "마무리" 작업 실행 (소스를 수정했거나 서버를 껐다 켰을 때)
	public void destroy() {
		System.out.println("destroy method...");
	}
	
	//클라이언트 요청이 들어올 때 마다 스레드가 생성되어서 병행적으로 서비스 함수를 수행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method888...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost method...");
	}
}
