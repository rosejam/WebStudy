package com.db;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tier3.Customer;
import com.tier3.CustomerDAO;

//Controller(servlet) : client로부터 들어오는 모든 요청을 받아서 Model을 이용해서 처리
@WebServlet("/Database")
public class Database extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. client로부터 들어오는 요청을 구분
		CustomerDAO dao = new CustomerDAO(); //Model 생성
		ArrayList<Customer> list = dao.selectAll();
		
		//Model이 만들어준 결과를 jsp에 출력 --> forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/start.jsp"); //여기로 request/response를 패스하겠다.
		request.setAttribute("list", list); //구한 값을 request객체에 첨부해서 저장
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
