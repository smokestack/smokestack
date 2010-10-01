package com.github.smokestack.jdbc.ex03;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Ignore;
import org.junit.Test;

import com.github.smokestack.jdbc.MockPreparedStatement;
import com.github.smokestack.jdbc.MockResultSet;
import com.github.smokestack.jdbc.MockStatement;


public class StatementExecute {
	
	@Test
	public void testExecuteRS() throws SQLException, ClassNotFoundException {
		new Expectations(){
			@Mocked( methods= {"_execute"})
			MockPreparedStatement pst;
			@Mocked (methods = {"_next", "_getInt", "_getString"})
			MockResultSet rs;
			{
				pst._execute((String)any);
				rs._next(); returns (true);
				rs._getInt(1); returns (2);
				rs._getString(2); returns("foo");
				rs._next(); returns (false);
			}
		};
		//Class.forName("org.hsqldb.jdbcDriver");
		Class.forName("com.github.smokestack.jdbc.MockDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:inmemory");
        //Statement stat = conn.createStatement();
        //stat.execute("create table message(id int primary key, message varchar(255))");
        //stat.execute("insert into message values (2, 'foo')");
        //stat.close();

        String sql = "SELECT id,message FROM message WHERE id >= ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, 2);
		pst.execute();
		ResultSet rs=pst.getResultSet();
		while (rs.next()){
			Integer id = rs.getInt(1);
			String msg = rs.getString(2);
			//System.out.println(id + "\t" + "- " + msg);
		}
		rs.close();
		pst.close();
		conn.close();
	}

	@Test
	@Ignore
	public void testExecuteRSDirect() throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		Driver mockDriver=DriverManager.getDriver("jdbc:hsqldb:mem");
		DriverManager.deregisterDriver(mockDriver);
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:inmemory");
        Statement stat = conn.createStatement();
        stat.execute("create table message(id int primary key, message varchar(255))");
        stat.execute("insert into message values (2, 'foo')");
        stat.close();

        String sql = "SELECT id,message FROM message WHERE id >= ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, 2);
		pst.execute();
		ResultSet rs=pst.getResultSet();
		while (rs.next()){
			Integer id = rs.getInt(1);
			String msg = rs.getString(2);
			System.out.println(id + "\t" + "- " + msg);
		}
		rs.close();
		pst.close();
		conn.close();
	}

	@Test
	@Ignore
	public void testExecuteInsertDirect() throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:inmemory");
        Statement stat = conn.createStatement();
        stat.execute("create table message1 (id int primary key, message varchar(255))");
        stat.execute("insert into message1 values (2, 'foo')");
        ResultSet rs=stat.getResultSet();
        stat.close();
	}
}
