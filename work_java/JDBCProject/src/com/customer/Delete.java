package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//selectAll로 확인
public class Delete {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "delete from customer where num = 729;";
		
		//1. Driver 등록
		Class.forName(driver);
		
		//2. Connection 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Statement 생성
		Statement stat = con.createStatement();
		
		//4. Query 실행
		int x = stat.executeUpdate(query);
		
		//5. 결과 처리
		System.out.println(x+"개의 레코드 삭제!!!");
		
		//6. 마무리 
		stat.close();
		con.close();
	}
}
