package net.sourceforge.smokestack.exception;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NotYetImplementedExceptionTest {

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
	public final void testNotYetImplementedExceptionStringThrowable() {
        NotYetImplementedException e=new NotYetImplementedException("some message", new Exception());
        assertThat(e.getMessage(), is("some message"));
	}

}
