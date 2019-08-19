package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMySQL2 {
//부서 번호가 50이상인 레코드의 사번, fname, email, deptid
	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "select empid, fname, email, deptid from emp where deptid >= 50";
		
		//1. Driver 등록
		Class.forName(driver);
		
		//2. Connection 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Statement 생성
		Statement stat = con.createStatement();
		
		//4. Query 실행
		ResultSet rs = stat.executeQuery(query);
		
		//5. 결과 처리
		while(rs.next()) {
			String empid = rs.getString(1);
			String fname = rs.getString(2);
			String email = rs.getString(3);
			String deptid = rs.getString(4);
			
			System.out.println(empid + "--" + fname + "--" + email+ "--" + deptid);
		}
		
		//6. 마무리 
		rs.close();
		stat.close();
		con.close();
	}
}
