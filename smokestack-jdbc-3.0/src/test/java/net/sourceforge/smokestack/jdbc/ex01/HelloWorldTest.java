package net.sourceforge.smokestack.jdbc.ex01;

import mockit.Expectations;
import mockit.Mocked;
import net.sourceforge.smokestack.jdbc.MockConnection;
import net.sourceforge.smokestack.jdbc.MockDriver;
import net.sourceforge.smokestack.jdbc.MockResultSet;
import net.sourceforge.smokestack.jdbc.MockStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelloWorldTest {

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
	public final void testMain() throws Exception {
		new Expectations(){
			@Mocked( methods= {"execute"})
			MockStatement st;
			@Mocked( methods= {"next", "getString"})			
			MockResultSet rs;
			{
				st.execute((String)any);
				st.execute((String)any);
				rs.next(); returns(true);
				rs.getString("name"); returns("hello");
				rs.next(); returns(false);
			}
		};
		Class.forName("net.sourceforge.smokestack.jdbc.MockDriver");	
		HelloWorld.main(new String[]{});
		// there is no easy way to get to the Connection ...
		MockConnection c=MockDriver.instance.getMockConnections().get(0);
		c.assertMockClosed();
	}

}
