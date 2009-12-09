package net.sourceforge.smokestack.jndi;

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
		assertThat(value, is(c.lookup(name)));
		c.unbind(name);
		try {
			c.lookup(name);
			fail("expected NamingExpection");
		} catch (NamingException ne){
			// IGNORE
		}
	}
}
