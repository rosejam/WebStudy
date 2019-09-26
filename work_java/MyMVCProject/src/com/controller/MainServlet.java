package com.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Algo;

//http://localhost:8080/MyMVCProject/main.do
@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		
		req.setCharacterEncoding("utf-8");		
		String action = req.getParameter("action");		
		
		if(action == null){	//처음에는 parameter가 없으므로 여기로
			RequestDispatcher dis = req.getRequestDispatcher("view/index.jsp");
			dis.forward(req, res);
			return;
		
		}else if(action.equals("q1")){//1번문제 합
			//parameter받아오기
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			
			File f = new File("res/input1.txt");
			//Algo 문제풀이 객체 생성 후 메소드 호출해서 결과 받기
			Algo a = new Algo(f);
			int[] result = a.doJob();
			
			//req에 결과 저장 후 jsp로 forward
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp");
			dis.forward(req,res);
			
		}else if(action.equals("q2")){//2번문제 제곱합
			//parameter받아오기
			String num3 = req.getParameter("num3");
			String num4 = req.getParameter("num4");
			
			File f2 = new File("C:/ssafy/work_java/MyMVCProject/input2.txt");
			//Algo 문제풀이 객체 생성 후 메소드 호출해서 결과 받기
			Algo a = new Algo(f2);
			int[] result = a.doJob2();
			
			//req에 결과 저장 후 jsp로 forward
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp");
			dis.forward(req,res);
			/*
			
			File f = new File("경ㄹ);
			Algo a = new Algo(f);
			String[] 			
		
			String[] result = a.doJob();
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp");
			dis.forward(req,res);*/
		}
		
	}
}