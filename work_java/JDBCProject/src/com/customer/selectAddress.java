package com.customer;
//주소가 london인 레코드 출력
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//customer table의 모든 데이터 출력
public class selectAddress {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "select num, name, address from customer where address = 'london'";
		
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
			String num = rs.getString(1);
			String name = rs.getString(2);
			String address = rs.getString(3);
			
			System.out.println(num + "--" + name + "--" + address);
		}
		
		//6. 마무리 
		rs.close();
		stat.close();
		con.close();
	}
}
