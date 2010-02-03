/**
 * 
 */
package net.sourceforge.smokestack.jdbc.ex04;

import static org.junit.Assert.*;

import java.sql.SQLException;

import mockit.Expectations;
import mockit.Mocked;
import net.sourceforge.smokestack.jdbc.MockConnection;
import net.sourceforge.smokestack.jdbc.MockDriver;
import net.sourceforge.smokestack.jdbc.MockStatement;
import net.sourceforge.smokestack.jdbc.ex03.PSSelect;

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
		MockDriver.instance.reset();
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
	 * Test method for {@link net.sourceforge.smokestack.jdbc.ex04.DeleteOp#main(java.lang.String[])}.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testMain() throws SQLException, ClassNotFoundException {
		new Expectations(){
			@Mocked (methods = {"_execute","_executeUpdate"})
			MockStatement st;
			{
				st._execute((String)any);
				st._executeUpdate((String)any); returns (0);
			}
		};
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
		try {
			DeleteOp.main(new String[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertClosed();
}

}
