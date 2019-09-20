package com.ssafy.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DBUtil;

public class LoginDAO {

	public boolean  loginCheck(String user, String pass) throws SQLException{
		//boolean flag=false;
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		String q="Select pw from Member where id=?";
		try{
			con=DBUtil.getConnection();
			ps=con.prepareStatement(q);
			ps.setString(1, user);
			rs=ps.executeQuery();
			if(rs.next()){
				String pw=rs.getString(1);
				if(pw.equals(pass)){
					return true;
				}							
			}			
		}finally{
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}	
		return false;
	}
	
}







