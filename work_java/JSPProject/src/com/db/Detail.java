package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Detail")
public class Detail extends HttpServlet {
	//멤버필드
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";

	String query = "select * from customer where num=?";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		try {
		//1. Driver 등록
		Class.forName(driver);
		
		//2. Connection 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. PreparedStatement 생성
		PreparedStatement pstat = con.prepareStatement(query);
		
		//3-1. ?에 값 setting
		pstat.setString(1, request.getParameter("num")); //전달된 num을 쿼리에
		
		//4. Query 실행
		ResultSet rs = pstat.executeQuery();
		
		//5. 결과 처리
		rs.next(); //record하나만 있는 경우지만, rs는 제목줄을 가르키고 있으므로 꼭 이작업을 해주어야 내용을 제대로 가르킨다!!
		
		String num = rs.getString(1);
		String name = rs.getString(2);
		String address = rs.getString(3);
		
		out.println("<table border=1>");
		out.println("<tr><th>번 호</th><td>"+num+"</td></tr>");
		out.println("<tr><th>이 름</th><td>"+name+"</td></tr>");
		out.println("<tr><th>주 소</th><td>"+address+"</td></tr>");
		out.println("</table>");
		
		out.println("<br><a href=JDBCServlet>back</a>");
		
		//6. 마무리 
		rs.close();
		pstat.close();
		con.close();

		}catch(Exception w) {
			w.printStackTrace();
		}
	}
}
