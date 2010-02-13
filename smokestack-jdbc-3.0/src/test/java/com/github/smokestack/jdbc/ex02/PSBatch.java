package com.github.smokestack.jdbc.ex02;

import java.sql.*;

public class PSBatch{
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement stat = null;
		try{
			Class.forName("org.hsqldb.jdbcDriver" );
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:inmemory");
	        stat = conn.createStatement();
	        stat.execute("create table message(id long primary key, message varchar(255))");
			conn.setAutoCommit(false);
			String sql = "INSERT into Message VALUES(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setLong(1,3);
			pst.setString(2,"Message 3");
			pst.addBatch();
			pst.setLong(1,4);
			pst.setString(2,"Message 4");
			pst.addBatch();
			pst.executeBatch();
			conn.commit();
		}
		finally{
			stat.close();
			pst.close();
			conn.close();
		}
	}
}
