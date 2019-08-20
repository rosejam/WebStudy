package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//selectAll로 확인
public class UpdatePre {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "update customer set address = ? where num = ?;";
		
		//1. Driver 등록
		Class.forName(driver);
		
		//2. Connection 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. PreparedStatement 생성
		PreparedStatement pstat = con.prepareStatement(query); //값부분을 ?로 표시해놓은 query그릇
		
		//3-1. ?에 값 setting
		pstat.setString(1, args[1]); //1번째 ?자리에 args[1]담음 //순서를 변경해서 작성할수 있음
		pstat.setString(2, args[0]);
		
		//4. Query 실행
		int x = pstat.executeUpdate();//pstat은 여기에 query를 제거
		
		//5. 결과 처리
		System.out.println(x+"개의 레코드 업뎃!!!");
		
		//6. 마무리 
		pstat.close();
		con.close();
	}
}
