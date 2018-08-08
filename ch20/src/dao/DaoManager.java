package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoManager {
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Connection conn=null;
	
	public Connection getConnection() {
		try {
			  Context init = new InitialContext();
			  DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OraDB");
			  conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}//getConnection()메소드 끝.
    
	
	public void close(PreparedStatement pstmt,ResultSet rs,Connection conn) {
		try {
			   rs.close(); pstmt.close(); conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement pstmt,Connection conn) {
		try {
			   pstmt.close(); conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
