package net.sourceforge.smokestack.exception;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class NeedsMockDefinitionExceptionTest {

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
	public final void testNeedsMockDefinitionStringThrowable() {
		NeedsMockDefinitionException e=new NeedsMockDefinitionException("some message", new Exception());
		assertThat("some message", is(e.getMessage()));
	}

}
