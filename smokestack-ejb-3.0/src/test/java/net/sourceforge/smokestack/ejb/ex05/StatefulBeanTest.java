/**
 * 
 */
package net.sourceforge.smokestack.ejb.ex05;

import static org.junit.Assert.*;

import net.sourceforge.smokestack.ejb.MockEJBContainer;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gliptak
 *
 */
public class StatefulBeanTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link net.sourceforge.smokestack.ejb.ex05.StatefulBean#initialize()}.
	 */
	@Test
	public final void testInitializeCleanup() {
		MockEJBContainer c=new MockEJBContainer();
		StatefulBean b=c.getInstance(StatefulBean.class);
		assertThat(b.initializeCalled, Is.is(true));
		c.cleanInstances();
		assertThat(b.cleanupCalled, Is.is(true));
	}

}
