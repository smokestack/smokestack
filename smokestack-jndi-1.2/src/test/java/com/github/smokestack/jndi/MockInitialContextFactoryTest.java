package com.github.smokestack.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MockInitialContextFactoryTest {

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
	public final void testGetInitialContext() throws NamingException {
		Hashtable environment=new Hashtable();
		environment.put("name", "value");
		environment.put("name1", "value1");
		Context c=new MockInitialContextFactory().getInitialContext(environment);
		assertThat((String)environment.get("name1"), is((String)c.getEnvironment().get("name1")));
	}

}
