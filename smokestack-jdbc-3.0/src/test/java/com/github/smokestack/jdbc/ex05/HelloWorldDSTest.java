package com.github.smokestack.jdbc.ex05;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jdbc.MockConnection;
import com.github.smokestack.jdbc.MockDataSource;
import com.github.smokestack.jdbc.MockResultSet;
import com.github.smokestack.jdbc.MockStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloWorldDSTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockDataSource.getInstance().reset();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMain() throws Exception {
		new Expectations() {
			@Mocked(methods = { "_execute", "_close" })
			MockStatement st;
			@Mocked(methods = { "_next", "_getString" , "_close"})
			MockResultSet rs;
			{
				st._execute((String) any);
				st._execute((String) any);
				rs._next();	returns(true);
				rs._getString("message"); returns("hello");
				rs._next(); returns(false);
				rs._close();
				st._close();
			}
		};
		MockDataSource ds = MockDataSource.getInstance();
		Context ctx = new InitialContext();
		ctx.bind("jdbc/dsName", ds);

		HelloWorldDS.main(new String[] {});
		// there is no easy way to get to the Connection ...
		MockConnection c = MockDataSource.instance.getMockConnections().get(0);
		c.assertExplicitClose();
		c.assertAutoCommit();
	}

	@Test
	public final void testMainAgain() throws Exception {
		new Expectations() {
			@Mocked(methods = { "_execute", "_close" })
			MockStatement st;
			@Mocked(methods = { "_next", "_getString" , "_close"})
			MockResultSet rs;
			{
				st._execute((String) any);
				st._execute((String) any);
				rs._next();	returns(true);
				rs._getString("message"); returns("hello");
				rs._next();	returns(false);
				rs._close();
				st._close();
			}
		};
		MockDataSource ds = MockDataSource.getInstance();
		Context ctx = new InitialContext();
		ctx.bind("jdbc/dsName", ds);

		HelloWorldDS.main(new String[] {});
		// there is no easy way to get to the Connection ...
		MockConnection c = MockDataSource.instance.getMockConnections().get(0);
		c.assertAutoCommit();
		c.assertClosed();
	}

	@Test
	public final void testMainRollback() throws Exception {
		new Expectations() {
			@Mocked(methods = { "_execute","_close" })
			MockStatement st;
			{
				st._execute((String) any); result=new SQLException ("something bad happened");
				st._close();
			}
		};
		MockDataSource ds = MockDataSource.getInstance();
		Context ctx = new InitialContext();
		ctx.bind("jdbc/dsName", ds);

		try{
			HelloWorldDS.main(new String[] {});
		}catch (SQLException se){
			// there is no easy way to get to the Connection ...
		}
		MockConnection c = MockDataSource.instance.getMockConnections().get(0);
		c.assertClosed();
	}
}
