/**
 * 
 */
package com.github.smokestack.jdbc.ex03;

import java.sql.SQLException;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jdbc.MockConnection;
import com.github.smokestack.jdbc.MockDriver;
import com.github.smokestack.jdbc.MockPreparedStatement;
import com.github.smokestack.jdbc.MockResultSet;
import com.github.smokestack.jdbc.MockStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author bbrag *
 */
public class PSSelectTest {

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
	 * Test method for {@link com.github.smokestack.jdbc.ex03.PSSelect#main(java.lang.String[])}.
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testMain() throws Exception {
		new Expectations(){
			@Mocked( methods= {"_execute"})
			MockStatement st;
			@Mocked (methods = {"_next", "_getLong", "_getString"})
			MockResultSet rs;
			{
				st._execute((String)any); returns(true);
				rs._next(); returns (true);
				rs._getLong(1); returns (1L);
				rs._getString(2); returns("message 1");
				rs._next(); returns (false);
			}
		};
		Class.forName("com.github.smokestack.jdbc.MockDriver");
		PSSelect.main(new String[] {});
 		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertClosed();
	}

	//@Test
	public void testMainException() throws Exception {
		new Expectations(){
			@Mocked( methods= {"_execute"})
			MockStatement st;
			@Mocked (methods = {"_next", "_getLong", "_getString"})
			MockResultSet rs;
			{
				st._execute((String)any);
				rs._next(); result=new SQLException("Something Bad happened");
				rs._getLong(1); returns (1L);
				rs._getString(2); returns("message 1");
				rs._next(); returns (false);
			}
		};
		Class.forName("com.github.smokestack.jdbc.MockDriver");
		try{
			PSSelect.main(new String[] {});
		}catch (Exception e){
			//do nothing
		}
 		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertClosed();
	}
}
