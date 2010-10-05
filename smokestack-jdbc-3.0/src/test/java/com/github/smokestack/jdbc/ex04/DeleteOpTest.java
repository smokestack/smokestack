/**
 * 
 */
package com.github.smokestack.jdbc.ex04;

import java.sql.SQLException;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jdbc.MockConnection;
import com.github.smokestack.jdbc.MockDriver;
import com.github.smokestack.jdbc.MockStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author bbrag *
 */
public class DeleteOpTest {

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
		MockDriver.instance.reset();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.github.smokestack.jdbc.ex04.DeleteOp#main(java.lang.String[])}.
	 * @throws Exception 
	 */
	@Test
	public void testMain() throws Exception {
		new Expectations(){
			@Mocked (methods = {"_execute","_executeUpdate"})
			MockStatement st;
			{
				st._execute((String)any);
				st._executeUpdate((String)any); returns (0);
			}
		};
		Class.forName("com.github.smokestack.jdbc.MockDriver");	
		DeleteOp.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertExplicitClose();
	}

	@Test
	public void testMainException() throws Exception {
		new Expectations(){
			@Mocked (methods = {"_createStatement"})
			MockConnection c;
			{
				c._createStatement(); result=new SQLException();
			}
		};
		Class.forName("com.github.smokestack.jdbc.MockDriver");	
		DeleteOp.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertExplicitClose();
	}
}
