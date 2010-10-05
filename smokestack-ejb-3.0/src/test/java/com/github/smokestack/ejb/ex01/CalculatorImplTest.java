/**
 * 
 */
package com.github.smokestack.ejb.ex01;

import com.github.smokestack.ejb.MockEJBContainer;

import static org.hamcrest.MatcherAssert.*;

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
public class CalculatorImplTest {

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
	 * Test method for {@link com.github.smokestack.ejb.ex01.CalculatorImpl#sum(int, int)}.
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public final void testSum() throws InstantiationException, IllegalAccessException {
		MockEJBContainer c=new MockEJBContainer();
		CalculatorImpl calc=c.getInstance(CalculatorImpl.class);
		assertThat(calc.sum(2, 3), Is.is(5));
	}

	/**
	 * Test method for {@link com.github.smokestack.ejb.ex01.CalculatorImpl#multiply(int, int)}.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public final void testMultiply() throws InstantiationException, IllegalAccessException {
		MockEJBContainer c=new MockEJBContainer();
		CalculatorImpl calc=c.getInstance(CalculatorImpl.class);
		assertThat(calc.multiply(2, 3), Is.is(6));
	}

}
