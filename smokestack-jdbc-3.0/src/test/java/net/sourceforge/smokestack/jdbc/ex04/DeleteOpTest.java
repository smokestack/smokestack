/**
 * 
 */
package net.sourceforge.smokestack.jdbc.ex04;

import java.sql.SQLException;

import mockit.Expectations;
import mockit.Mocked;
import net.sourceforge.smokestack.jdbc.MockConnection;
import net.sourceforge.smokestack.jdbc.MockDriver;
import net.sourceforge.smokestack.jdbc.MockStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author KAHBZB
 *
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
	 * Test method for {@link net.sourceforge.smokestack.jdbc.ex04.DeleteOp#main(java.lang.String[])}.
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
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
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
				c._createStatement(); throwsException(new SQLException());
			}
		};
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
		DeleteOp.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertExplicitClose();
	}
}
