package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMySQL {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		//jdbc url
		//jdbc는 protocol name, mysql은 db이름, localhost(db가 있는 ip주소를 입력)는 db server 주소, 3306은 port번호, scott은 schema 이름
		//UTC는 표준시를 의미
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "select empid, fname, phone from emp";
		
		//1. Driver 등록
		Class.forName(driver); 	//클래스이름으로 바로 호출하는 스태틱 메서드 forname()
								//forname("패키지이름.클래스이름");하면 그 클래스가 new된다. = "객체생성"
								//만약 oracle용 드라이버를 사용할 경우, args[1]등을 해서 다른 드라이버 객체 생성을 한다. (유동적인 객체 생성을 할 수 있음)
								//드라이버 중 대표로 "시작 클래스"만 driver로 생성(등록)해놓으면 다른 클래스들은 자동으로 생성되므로 신경X
		
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
			String phone = rs.getString(3);
			
			System.out.println(empid + "--" + fname + "--" + phone);
		}
		
		//6. 마무리 
		rs.close();
		stat.close();
		con.close();
	}
}
