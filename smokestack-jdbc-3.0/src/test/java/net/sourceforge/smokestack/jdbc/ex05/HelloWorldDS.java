/*
 * Copyright 2004-2010 H2 Group. Multiple-Licensed under the H2 License, Version
 * 1.0, and under the Eclipse Public License, Version 1.0
 * (http://h2database.com/html/license.html). Initial Developer: H2 Group
 */
package net.sourceforge.smokestack.jdbc.ex05;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * A very simple class that shows how to load the driver, create a database,
 * create a table, and insert some data.
 */
public class HelloWorldDS {

	/**
	 * Called when ran from command line.
	 * 
	 * @param args ignored
	 */
	public static void main(String... args) throws Exception {
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("jdbc/dsName");
		Connection conn = ds.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = null;

		try{
			stat.execute("create table message(id int primary key, message varchar(255))");
			stat.execute("insert into message values(1, 'Hello World')");
			rs = stat.executeQuery("select * from message");
			while (rs.next()) {
				System.out.println(rs.getString("message"));
			}
		}
		finally{
			if(rs != null){
				rs.close();
			}
			if(stat != null){
				stat.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
}
