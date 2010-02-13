package com.github.smokestack.jms.ex04;

import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jms.MockConnectionFactory;
import com.github.smokestack.jms.MockMessage;
import com.github.smokestack.jms.MockMessageConsumer;
import com.github.smokestack.jms.MockTextMessage;
import com.github.smokestack.jms.MockTopic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DurableSubscriberTest {

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
		Context c=new InitialContext();
		final MockConnectionFactory cf=new MockConnectionFactory();
		c.bind("ConnectionFactory", cf);
		c.bind("topic", new MockTopic("topicName"));

		new Expectations(){
			@Mocked( methods= {"_receive"})
			MockMessageConsumer c;
			{
				c._receive(); returns(new MockTextMessage("Message 1"));
				c._receive(); returns(new MockMessage());
				c._receive(); returns(new MockTextMessage("Message 3"));
			}
		};
		
		DurableSubscriber.main(new String[]{"topic", "3"});
		cf.assertMockComplete();
		c.close();
	}

}
