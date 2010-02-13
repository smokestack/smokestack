package com.github.smokestack.jms.ex02;

import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jms.MockConnectionFactory;
import com.github.smokestack.jms.MockMessageConsumer;
import com.github.smokestack.jms.MockQueue;
import com.github.smokestack.jms.MockTextMessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReceiverTest {

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
	public final void testMain() throws NamingException, JMSException {
		new Expectations(){
			@Mocked( methods= {"_receive"})
			MockMessageConsumer c;
			{
				c._receive(); returns(new MockTextMessage("Message 1"));
				c._receive(); returns(new MockTextMessage("Message 2"));
				c._receive(); returns(new MockTextMessage("Message 3"));
			}
		};
		Context c=new InitialContext();
		MockConnectionFactory cf=new MockConnectionFactory();
		c.bind("ConnectionFactory", cf);
		c.bind("queue", new MockQueue("queue"));
		Receiver.main(new String[]{"queue", "3"});
		cf.assertMockComplete();
		c.close();
	}
}
