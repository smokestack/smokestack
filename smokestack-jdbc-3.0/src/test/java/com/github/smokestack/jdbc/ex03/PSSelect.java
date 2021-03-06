/**
 * 
 */
package com.github.smokestack.jdbc.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author bbrag *
 */

public class PSSelect{
	public static void main(String[] args) throws Exception{
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Class.forName("org.hsqldb.jdbcDriver" );
		try{
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:inmemory");
	        stat = conn.createStatement();
	        stat.execute("create table message(id long primary key, message varchar(255))");
	        stat.close();

	        String sql = "SELECT id,message FROM message WHERE id >= ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,2);
			rs = pst.executeQuery();
			while (rs.next()){
				Long id = rs.getLong(1);
				String msg = rs.getString(2);
				System.out.println(id + "\t" + "- " + msg);
			}
		}
		finally{
			rs.close();
			pst.close();
			conn.close();
		}
	}
}
