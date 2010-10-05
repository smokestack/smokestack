/**
 * 
 */
package com.github.smokestack.jms.ex01;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jms.MockConnectionFactory;
import com.github.smokestack.jms.MockMessageProducer;
import com.github.smokestack.jms.MockTopic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gliptak
 *
 */
public class SenderTest {

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
	 * Test method for {@link com.github.smokestack.jms.ex01.Sender#main(java.lang.String[])}.
	 * @throws NamingException 
	 * @throws JMSException 
	 */
	@Test
	public final void testMain() throws NamingException, JMSException {
		new Expectations(){
			@Mocked( methods= {"_send"})
			MockMessageProducer p;
			{
				p._send(withInstanceOf(Message.class));
				p._send(withInstanceOf(Message.class));
				p._send(withInstanceOf(Message.class));
			}
		};
		Context c=new InitialContext();
		MockConnectionFactory cf=new MockConnectionFactory();
		c.bind("ConnectionFactory", cf);
		c.bind("topic", new MockTopic("topic"));
		Sender.main(new String[]{"topic", "3"});
		cf.assertMockComplete();
		c.close();
	}

}
