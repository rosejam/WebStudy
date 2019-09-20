package chapter02;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param1.do")
public class ParamTest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String text = request.getParameter("text");
		String password = request.getParameter("password");
		String[] hobby = request.getParameterValues("hobby");
		String content = request.getParameter("content");
		
		System.out.println("text:"+text);
		System.out.println("password:"+password);
		System.out.println("hobby:"+Arrays.toString(hobby));
		System.out.println("content:"+content);
	}
}
