/**
 * 
 */
package net.sourceforge.smokestack.jdbc.ex02;

import static org.junit.Assert.*;

import java.sql.SQLException;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import net.sourceforge.smokestack.jdbc.MockConnection;
import net.sourceforge.smokestack.jdbc.MockDriver;
import net.sourceforge.smokestack.jdbc.MockPreparedStatement;
import net.sourceforge.smokestack.jdbc.MockResultSet;
import net.sourceforge.smokestack.jdbc.MockStatement;
import net.sourceforge.smokestack.jdbc.ex01.HelloWorld;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author KAHBZB
 *
 */
@RunWith(JMockit.class)
public class PSBatchTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockDriver.instance.reset();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link net.sourceforge.smokestack.jdbc.ex02.PreparedStatementUpdate#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() throws Exception {
		new Expectations(){
			@Mocked( methods= {"_execute"})
			MockStatement st;
			@Mocked( methods= {"_executeBatch"})
			MockPreparedStatement pst;
			@Mocked( methods= {"_commit"})
			MockConnection conn;
			{
				st._execute((String)any);
				pst._executeBatch(); returns(new int[]{0});
			}
		};
		
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
		PSBatch.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertExplicitCommit();
		c.assertClosed();
	}

	/**
	 * Test method for {@link net.sourceforge.smokestack.jdbc.ex02.PreparedStatementUpdate#main(java.lang.String[])}.
	 * @throws SQLException 
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testMainThrowOnCommit() throws SQLException, ClassNotFoundException {
		new Expectations(){
			@Mocked( methods= {"_commit"})
			MockConnection c;
			@Mocked( methods= {"_execute"})
			MockStatement st;
			@Mocked( methods= {"_executeBatch"})
			MockPreparedStatement pst;
			{
				st._execute((String)any);
//				c._commit(); throwsException(new NullPointerException("something bad happened"));
//				BAD c._commit(); throwsException(new Exception("something bad happened"));
				c._commit(); throwsException(new SQLException("something bad happened"));
			}
		};
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");
		try {
			PSBatch.main(new String[]{});
			fail("expected Exception");
		} catch (Exception e){
			MockConnection c=MockDriver.instance.getMockConnections().get(0);
			c.assertAutoRollback();
//			not c.assertMockRollback();
			c.assertClosed();
			c.assertExplicitClose();
		}
	}

	/**
	 * Test method for {@link net.sourceforge.smokestack.jdbc.ex02.PreparedStatementUpdate#main(java.lang.String[])}.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testMainOverrideCommit() throws SQLException, ClassNotFoundException {
		new Expectations(){
			@Mocked( methods= {"_commit"})
			MockConnection c;
			@Mocked( methods= {"_execute"})
			MockStatement st;
			@Mocked( methods= {"_executeBatch"})
			MockPreparedStatement pst;
			{
				st._execute((String)any);
				c._commit();
			}
		};
		
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
		PSBatch.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertExplicitCommit();
		c.assertClosed();
	}

	/**
	 * Test method for {@link net.sourceforge.smokestack.jdbc.ex02.PreparedStatementUpdate#main(java.lang.String[])}.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testMainValidateOnCommit() throws SQLException, ClassNotFoundException {
		new Expectations(){
			@Mocked( methods= {"_commit"})
			MockConnection c;
			@Mocked( methods= {"_execute"})
			MockStatement st;
			@Mocked( methods= {"_executeBatch"})
			MockPreparedStatement pst;
			{
				st._execute((String)any);
				c._commit(); returns (
					new Delegate(){
						void foo(){
							//TODO: do your own asserts here.
						}
					}
				);
			};
		};
		
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
		PSBatch.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertClosed();
	}
}


