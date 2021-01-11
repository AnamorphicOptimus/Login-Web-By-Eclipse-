package cn.edu.uibe.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	public static final String url="jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf8";
	public static final String driverName="com.mysql.jdbc.Driver";
	
	public static Connection getConn() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Class.forName(driverName);
		conn = DriverManager.getConnection(url,"root","123456");
		return conn;
	}
	
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn){
		if(rs!=null){
			try{rs.close();}catch(Exception ignore){}
		}
		if(pstmt!=null){
			try{pstmt.close();}catch(Exception ignore){}
		}
		if(conn!=null){
			try{conn.close();}catch(Exception ignore){}
		}
	}

}
