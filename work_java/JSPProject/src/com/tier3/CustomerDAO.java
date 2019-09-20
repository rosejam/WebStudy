package com.tier3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//<DAO> : DB에 접근해서 CRUD(Create/Read/Update/Delete) 작업을 수행하는 객체
public class CustomerDAO implements ICustomerDAO { //필드, 생성자, 오버라이딩
	
	//FIELD(DB작업위한 정보)
	String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8&useUniCode=yes";
	
	String user = "scott";
	String password = "tiger";
	
	//생성자 //클라이언트에서 생성
	public CustomerDAO() {
		//1. Driver 등록(한번만 하면 됨)
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) { //driver클래스를 못찾는 경우
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection getConnection() {//2. Connection 생성
		Connection con = null; //트라이캐치 바깥에서 null로 우선 초기화해야 오류X!!!
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con; //리턴은 트라이캐치 바깥에서 해주어야함!(익셉션 발생하더라도 캐치 끝난 후 리턴이 되도록!!!!)
					//익셉션 발생시 null이 리턴이 됨
	}

	@Override
	public ArrayList<Customer> selectAll() {
		String q = "select * from customer order by num";
		ArrayList<Customer> list = new ArrayList<>();
		//2. Connection 생성
		Connection con = getConnection(); //위에 작성한 메서드 이용
		try {
			//3. Statement 생성
			Statement stat = con.createStatement();
			//4. Query 실행
			ResultSet rs = stat.executeQuery(q);
			
			//5. 결과 처리
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				
				//System.out.println(num + "--" + name + "--" + address); //출력은 클라이언트에서 하는 것
				Customer c = new Customer(num, name, address);
				list.add(c);
			}
			//6. 마무리 
			close(stat, rs, con, null);//아래 작성한 메서드 이용
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer selectOne(String num) {
		String q = "select * from customer where num = ?";
		//2. Connection 생성
		Connection con = getConnection();
		Customer c = null;
		
		try {
			//3. PreparedStatement 생성 
			PreparedStatement pstat = con.prepareStatement(q);
			//3-1. ?에 값 setting //컬럼명은 안됨!!
			pstat.setString(1, num); 
			//4. Query 실행
			ResultSet rs = pstat.executeQuery();
			//5. 결과 처리
			if(rs.next()) { //데이터가 있을 경우!!!!//(실제 데이터 (첫번째) 레코드 가리키도록 호출함)
				c = new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			//6. 마무리 
			close(null, rs, con, pstat);//아래 작성한 메서드 이용
		}catch(SQLException e){
			e.printStackTrace();
		}

		return c; //데이터가 없으면 null이 리턴된다.
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		String q = "select * from customer where address = ?";
		ArrayList<Customer> list = new ArrayList<>();
		//2. Connection 생성
		Connection con = getConnection();
		try {
			//3. PreparedStatement 생성 
			PreparedStatement pstat = con.prepareStatement(q);
			//3-1. ?에 값 setting //컬럼명은 안됨!!
			pstat.setString(1, address); 
			//4. Query 실행
			ResultSet rs = pstat.executeQuery();
			//5. 결과 처리
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address1 = rs.getString(3);
				
				//System.out.println(num + "--" + name + "--" + address); //출력은 클라이언트에서 하는 것
				Customer c = new Customer(num, name, address1);
				list.add(c);
			}
			//6. 마무리 
			close(null, rs, con, pstat);
		}catch(SQLException e){
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int insert(Customer c) {
		String query = "insert into customer values(?,?,?);";
		//2. Connection 생성
		Connection con = getConnection();
		int x = 0;
		
		try {
			//3. PreparedStatement 생성 
			PreparedStatement pstat = con.prepareStatement(query);
			//3-1. ?에 값 setting //컬럼명은 안됨!!
			pstat.setString(1, c.getNum()); 
			pstat.setString(2, c.getName());
			pstat.setString(3, c.getAddress());
			//4. Query 실행
			x = pstat.executeUpdate();
			//5. 결과 처리
			//System.out.println(x+"개의 레코드 추가!!!");
			//6. 마무리 
			close(null, null, con, pstat);//아래 작성한 메서드 이용
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public int update(String num, String address) {
		String query = "update customer set address = ? where num = ?;";
		//2. Connection 생성
		Connection con = getConnection();
		int x = 0;
		
		try {
			//3. PreparedStatement 생성 
			PreparedStatement pstat = con.prepareStatement(query);
			//3-1. ?에 값 setting //컬럼명은 안됨!!
			pstat.setString(1, address); 
			pstat.setString(2, num);
			//4. Query 실행
			x = pstat.executeUpdate();
			//5. 결과 처리
			//System.out.println(x+"개의 레코드 업뎃!!!");
			//6. 마무리 
			close(null, null, con, pstat);//아래 작성한 메서드 이용
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public int delete(String num) {
		String query = "delete from customer where num = ?;";
		//2. Connection 생성
		Connection con = getConnection();
		int x = 0;
		
		try {
			//3. PreparedStatement 생성 
			PreparedStatement pstat = con.prepareStatement(query);
			//3-1. ?에 값 setting //컬럼명은 안됨!!
			pstat.setString(1, num); 
			//4. Query 실행
			x = pstat.executeUpdate();
			//5. 결과 처리
			//System.out.println(x+"개의 레코드 업뎃!!!");
			//6. 마무리 
			close(null, null, con, pstat);//아래 작성한 메서드 이용
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public void close(Statement stat, ResultSet rs, Connection con, PreparedStatement pstat) { //6. 마무리 
		try {
			if(stat!=null)
				stat.close();
			if(pstat!=null)
				pstat.close();
			if(rs!=null)
				rs.close();
			if(con!=null)
				con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
