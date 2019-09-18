package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//DAO:DB에 접근해서 CRUD(Create/Read/Update/Delete) 작업을 수행하는 객체
public class CustomerDAO implements ICustomerDAO {

	// FIELD
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";

	String user = "scott";
	String password = "tiger";

	// 생성자:1.Driver 등록-> 앞으로 사용할 db 등록
	public CustomerDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2.Connection 생성 - network 연결
	@Override
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		String q = "select * from customer order by num";
		ArrayList<Customer> list = new ArrayList<>();

		try {
			Connection con = getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);

			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);

				Customer c = new Customer(num, name, address);
				list.add(c);
			}

			close(stat, rs, con, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer selectOne(String num) {
		String q = "select * from customer where num = ?";
		Connection con = getConnection();
		Customer c = null;

		try {
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {// ****** 데이터가 있다면
				c = new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		String q = "select * from customer where address = ?";
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = getConnection();
		try {
			
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, address);
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Customer c = new Customer(rs.getString(1), rs.getString(2), address);
				list.add(c);
			}
			rs.close();
			pstat.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insert(Customer c) {
		String q = "insert into customer values(?,?,?)";
		Connection con = getConnection();
		PreparedStatement pstat;
		int x=0;
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, c.getNum());
			pstat.setString(2, c.getName());
			pstat.setString(3, c.getAddress());
			x = pstat.executeUpdate();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return x;
	}

	@Override
	public int update(String num, String address) {
		String q = "update customer set address = ? where num = ?";
		Connection con = getConnection();
		PreparedStatement pstat;
		int x=0;
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(2, num);
			pstat.setString(1, address);
			x = pstat.executeUpdate();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return x;
	}

	@Override
	public int delete(String num) {
		String q = "delete from customer where num = ?";
		Connection con = getConnection();
		PreparedStatement pstat;
		int x=0;
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			x = pstat.executeUpdate();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return x;
	}

	@Override
	public void close(Statement stat, ResultSet rs, Connection con, PreparedStatement pstat) {
		try {
			if (stat != null)
				stat.close();			
			if (pstat != null)
				pstat.close();
			
			if (rs != null)
				rs.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
