package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//batch(여러개의 작업을 하나로 묶은 것) 처리 + Transaction 처리(하나의 단위로 묶여서 처리되어야 하는 작업)
public class InsertBatch {

	public static void main(String[] args){
		String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		Connection con = null; 
		Statement stat = null; //try catch 바깥으로 뺀다.
		
		try {
			//1. Driver 등록
			Class.forName(driver);
			
			//2. Connection 생성
			con = DriverManager.getConnection(url, user, password);
			
			//3. Statement 생성
			stat = con.createStatement();
			
			//3-1. batch에 작업 추가(stat에 query 담아놓기)
			stat.addBatch("insert into customer values(1,'queen','london')");
			stat.addBatch("insert into customer values(4,'king','la')");
			stat.addBatch("insert into customer values(2,'prince','seoul')");
			
			//3-2. auto-commit off
			con.setAutoCommit(false);
			
			//4. Query 실행
			int[] x = stat.executeBatch(); //배치 실행
			con.commit(); //중간에 문제가 없었을 경우 batch를 모두 commit한다.
			
			//5. 결과 처리
			System.out.println("commit all...");
		
		}catch(Exception w) { //중간에 문제가 발생하면 batch가 모두 rollback된다.
			try {
				con.rollback();
				System.out.println("rollback 성공...");
			} catch (SQLException e) {
				System.out.println("rollback 실패...");
			}
		}
		
		//6. 마무리 
		try {
			stat.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("close 실패...");
		}
	}
}
