package cn.edu.uibe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.uibe.db.DBConn;
import cn.edu.uibe.domain.User;

public class UserDAO {
	
	public User findUserByUserName(String userName){
		if(userName==null) return null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			String sql = "SELECT * FROM USER WHERE USER_NAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getLong("ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setEmail(rs.getString("EMAIL"));
				return user;//首先执行finally,然后再返回
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConn.closeAll(rs, pstmt, conn);
		}		
		return null;
	}
	

}
