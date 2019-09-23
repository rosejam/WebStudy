package com.dao;
//DAO(Data Access Object): jsp를 위해 db 작업 수행

//Create, Read, Update, Delete

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vo.Board;

public class BoardDAO implements IBoard {

	// db 연동위한 FIELD 추가하기
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";

	String user = "scott";
	String password = "tiger";
	
	// 생성자: 객체 생성시에 자동 호출됨
	public BoardDAO() {
		//driver 등록
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	// 2.Connection 생성 - network 연결	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			Statement stat = con.createStatement();
			String q = "select num,name,wdate,title,count from board order by num desc;"; //최신글부터 보기
			ResultSet rs = stat.executeQuery(q);

			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String count = rs.getString(5);

				// 뽑은 5개의 값을 vo에 저장
				Board b = new Board(num, null, name, wdate, title, null, count);
				list.add(b);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Board selectOne(String num) {		
		Board b = null;
		Connection con = getConnection();
		
		try {
			String q = "select num,name,wdate,title,content,count from board where num=?;";
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			
			ResultSet rs = pstat.executeQuery();
			
			if(rs.next()) {
				b = new Board(rs.getString(1), null, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public void insert(Board b) {
		String q = "insert into board(pass,name,wdate,title,content,count) values(?,?,sysdate(),?,?,0);"; //num은 넣지 않기!!(자동으로 매겨짐)
		Connection con = getConnection();
		
		try {
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, b.getPass());
			pstat.setString(2, b.getName());
			pstat.setString(3, b.getTitle());
			pstat.setString(4, b.getContent());
			
			pstat.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String num) {
		String q = "delete from board where num=?;";
		Connection con = getConnection();
		
		try {
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			
			pstat.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Board> search(String condition, String word) { //글제목 or 글쓴이
		String q = "select num,name,wdate,title,count from board where " +condition+ " like ?;"; //이어서 쓰니까 안됬다. ?가 아닌 condition을 따로 꺼내서 쓰기
		ArrayList<Board> list = new ArrayList<>(); 
		Connection con = getConnection();
		try {
			PreparedStatement pstat = con.prepareStatement(q);
			//pstat.setString(1, condition); 
			pstat.setString(1, "%"+word+"%"); 

			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String count = rs.getString(5);
				
				//System.out.println(num + "--" + name + "--" + address); //출력은 클라이언트에서 하는 것
				Board c = new Board(num, null, name, wdate, title, null, count);
				list.add(c);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void countUp(String num) { //read한 경우 selectOne전에 조회수 올리기용!!!
		Connection con = getConnection();
		String q = "update board set count = count + 1 where num = ?;"; //count에 +1을 한다
		try {
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			pstat.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
