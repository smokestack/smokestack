package com.github.smokestack.jndi;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockContextTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testBindStringObject() throws NamingException {
		String name="java:comp/env/ejb/Customer";
		Object value="Customer";
		Context c=new InitialContext();
		try {
			c.lookup(name);
			fail("expected NamingExpection");
		} catch (NamingException ne){
			// IGNORE
		}
		c.bind(name, value);
		c.rebind(name, value);
		assertThat(c.lookup(name), is(value));
		c.unbind(name);
		try {
			c.lookup(name);
			fail("expected NamingExpection");
		} catch (NamingException ne){
			// IGNORE
		}
	}
	
	@Test
	public final void testCheckCheck() throws NamingException {
		String name="java:comp/env/ejb/Customer";
		Object value="Customer";
		{
			Context c1=new InitialContext();
			c1.bind(name, value);
			assertThat(c1.lookup(name), is(value));			
		}
		{
			Context c2=new InitialContext();
			assertThat(c2.lookup(name), is(value));			
			c2.unbind(name);			
		}
		{
			Context c3=new InitialContext();
			try {
				c3.lookup(name);
				fail("expected NamingExpection");
			} catch (NamingException ne){
				// IGNORE
			}			
		}
	}
	@Test
	public final void testClose() throws NamingException {
		String name="java:comp/env/ejb/Customer";
		Object value="Customer";
		{
			Context c1=new InitialContext();
			c1.bind(name, value);
			assertThat(c1.lookup(name), is(value));
			c1.close();
			try {
				c1.lookup(name);
				fail("expected NamingExpection");
			} catch (NamingException ne){
				// IGNORE
			}			
		}
		{
			Context c3=new InitialContext();
			try {
				c3.lookup(name);
				fail("expected NamingExpection");
			} catch (NamingException ne){
				// IGNORE
			}			
		}
	}
}
