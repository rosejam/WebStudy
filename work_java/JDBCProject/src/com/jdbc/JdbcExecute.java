package com.jdbc;

import java.sql.*;

public class JdbcExecute {

	public static void main(String args[]) {
/*		String driver = "oracle.jdbc.driver.OracleDriver";
		String db_connect = new String("jdbc:oracle:thin:@127.0.0.1:1521:ORCL"); //오라클용 url
		String db_user = new String("scott");
		String db_passwd = new String("tiger"); */
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		String user = "scott";
		String password = "tiger";
		
		String str1 = "select * from customer";
		String str2 = "insert into customer values(987,'hee','la')";

		Connection conn;
		Statement stat;
		try {
			//1. Driver 등록
			Class.forName(driver);
			//2. Connection 생성
			conn = DriverManager.getConnection (url, user, password);
			
			//3. Statement 생성
			stat = conn.createStatement();

			//4. Query 실행 : execute()는 쿼리문이 select여도 아니어도 상관없다 -> 리턴 boolean
			boolean flag = stat.execute(str1); //select o -> stat.executeQuery(str1) -> ResultSet
	//		boolean flag = stat.execute(str2); //select x -> stat.executeUpdate(str2) -> int

			if(flag == true){ //select를 실행한 경우 true가 return
				ResultSet rs = stat.getResultSet(); //이 메서드로 ResultSet을 따로 얻어내야 함

				while(rs.next()) {
					String num  = rs.getString(1);
					String name  = rs.getString(2);
					String address   = rs.getString(3);
					System.out.println(num + "-- " +name + "-- " + address );
				}
			}			
			else{ //select를 실행하지 않은 경우 false가 return
				int rows = stat.getUpdateCount(); //이 메서드로 int값을 따로 얻어낼 수 있다.
				if (rows != 0)
					System.out.println("operation ok....!!!");
				else 
					System.out.println("no changes made...!!!");
			}
			stat.close();
			conn.close();
		} catch ( Exception e ) {
			System.out.println(" error sql");
			e.printStackTrace();
		}
	}
}