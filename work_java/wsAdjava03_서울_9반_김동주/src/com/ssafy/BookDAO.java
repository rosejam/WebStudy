package com.ssafy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookDAO {
	
	//FIELD
	String driver = "com.mysql.cj.jdbc.Driver"; //패키지이름.클래스이름
	String url = "jdbc:mysql://localhost:3306/tommy?serverTimezone=UTC&characterEncoding=UTF-8";
	
	String user = "tommy";
	String password = "lion";

	public BookDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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
	public void close(Connection connection) { //6. 마무리 
		try {

			if(connection!=null)
				connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
/*	@Override
	public void close(PreparedStatement preparedstatement) { //6. 마무리 
		try {
			if(preparedstatement!=null)
				preparedstatement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	@Override
	public void close(Statement statement) { //6. 마무리 
		try {
			if(statement!=null)
				statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close(ResultSet resultset) { //6. 마무리 
		try {

			if(resultset!=null)
				resultset.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertBook(Book book) {
		String query = "insert into book values(?,?,?,?,?,?);";
		Connection con = getConnection();
		//int x = 0;
		
		try {
			PreparedStatement pstat = con.prepareStatement(query);
			pstat.setString(1, book.getIsbn()); 
			pstat.setString(2, book.getTitle());
			pstat.setString(3, book.getAuthor());
			pstat.setString(4, book.getPublisher());
			pstat.setInt(5, book.getPrice());
			pstat.setString(6, book.getDescription());
			pstat.executeUpdate();
			//System.out.println(x+"개의 레코드 추가!!!");
			close(pstat);
			close(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return;
	}

	@Override
	public void updateBook(Book book) {
		String query = "update book set title=?,author=?,publisher=?,price=?,description=? where isbn = ?;";
		Connection con = getConnection();
		//int x = 0;
		
		try {
			PreparedStatement pstat = con.prepareStatement(query);
			pstat.setString(6, book.getIsbn()); 
			pstat.setString(1, book.getTitle());
			pstat.setString(2, book.getAuthor());
			pstat.setString(3, book.getPublisher());
			pstat.setInt(4, book.getPrice());
			pstat.setString(5, book.getDescription());
			pstat.executeUpdate();
			//System.out.println(x+"개의 레코드 추가!!!");
			close(pstat);
			close(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return;
	}

	@Override
	public void delete(String isbn) {
		String query = "delete from book where isbn = ?;";
		Connection con = getConnection();
		//int x = 0;
		
		try {
			PreparedStatement pstat = con.prepareStatement(query);
			pstat.setString(1, isbn); 
			pstat.executeUpdate();
			//System.out.println(x+"개의 레코드 추가!!!");
			close(pstat);
			close(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return;
	}

	@Override
	public Book findBook(String isbn) {
		String q = "select * from book where isbn = ?";
		Connection con = getConnection();
		Book b = null;
		
		try {
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, isbn); 
			ResultSet rs = pstat.executeQuery();
			if(rs.next()) { 
				b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
			}
			close(pstat);
			close(rs);
			close(con);
		}catch(SQLException e){
			e.printStackTrace();
		}

		return b;
	}

	@Override
	public List<Book> listBooks() {
		String q = "select * from book order by isbn";
		List<Book> list = new ArrayList<>();
		Connection con = getConnection(); 
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			while(rs.next()) {
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				String publisher = rs.getString(4);
				int price = rs.getInt(5);
				String description = rs.getString(6);
				Book b = new Book(isbn, title, author, publisher, price, description);
				list.add(b);
			}
			close(stat);
			close(rs);
			close(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		String q = "select count(*) from book;";
		Connection con = getConnection(); 
		int x = 0;
		try {
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			rs.last();
			x=rs.getRow();
			close(stat);
			close(rs);
			close(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}
