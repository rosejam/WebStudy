package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//customer table의 모든 데이터 출력 //확인
public class selectAll2 {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "select * from customer";
		
		//1. Driver 등록
		Class.forName(driver);
		
		//2. Connection 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. Statement 생성
		Statement stat = con.createStatement();
		
		//4. Query 실행
		ResultSet rs = stat.executeQuery(query);
		rs.last(); //rs의 마지막 레코드 행을 가리킴
		System.out.println(rs.getRow()); //그 행의 번호 = rs안의 레코드 갯수
		rs.beforeFirst(); //다시 제목줄(0번째 행)을 가리킴
		
		//5. 결과 처리
		while(rs.next()) {
			String num = rs.getString(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			
			System.out.println(num + "--" + name + "--" + address);
		}
		
		//rs테이블의 마지막행 "아래"에서 루프 벗어남
/*		System.out.println("-------------");
		rs.previous(); //한 행 올라가서 rs의 마지막 레코드 행을 가리킴
		System.out.println(rs.getString(1) + "--" + rs.getString(2));
		System.out.println(rs.getRow());  //그 행의 번호 = rs안의 레코드 갯수
		*/
		
		while(rs.previous()) {
			String num = rs.getString(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			
			System.out.println(num + "--" + name + "--" + address);
		}
		
		System.out.println("-------------");
		rs.first(); //rs.의 첫 데이터 행
		System.out.println(rs.getString(1) + "--" + rs.getString(2));
		
		

		//6. 마무리 
		rs.close();
		stat.close();
		con.close();
	}
}
