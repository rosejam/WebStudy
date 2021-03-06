package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//query
public class InsertPre {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		//String query = "insert into customer values(" + args[0] +",'"+ args[1] +"','"+ args[2] + "');"; //여기서 에러가 많이 발생한다
		String query = "insert into customer values(?,?,?);";
		//System.out.println(query);
		
		//1. Driver 등록
		Class.forName(driver);
		
		//2. Connection 생성
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3. PreparedStatement 생성 //PreparedStatement : 실행할 쿼리문의 일부가 미리 담겨있는 그릇
		//Statement stat = con.createStatement(); 
		PreparedStatement pstat = con.prepareStatement(query); //값부분을 ?로 표시해놓은 query그릇
		
		//3-1. ?에 값 setting //컬럼명은 안됨!!
		pstat.setString(1, args[0]); //1번째 ?자리에 args[0]담음 따옴표는 알아서함
		pstat.setString(2, args[1]);
		pstat.setString(3, args[2]);
		
		//4. Query 실행
		int x = pstat.executeUpdate(); //pstat은 여기에 query를 제거
		
		//5. 결과 처리
		System.out.println(x+"개의 레코드 추가!!!");
		
		//6. 마무리 
		pstat.close();
		con.close();
	}
}
