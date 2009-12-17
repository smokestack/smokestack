package net.sourceforge.smokestack.ejb.ex02;

import static org.hamcrest.MatcherAssert.assertThat;

import net.sourceforge.smokestack.ejb.MockEJBContainer;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CounterImplTest {

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
	public final void testIncrement() throws InstantiationException, IllegalAccessException {
		MockEJBContainer c=new MockEJBContainer();
		CounterImpl c1=c.getInstance(CounterImpl.class);
		assertThat(c1.increment(), Is.is(1));
		CounterImpl c2=c.getInstance(CounterImpl.class);
		assertThat(c2.increment(), Is.is(2));
	}

}
