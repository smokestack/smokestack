package net.sourceforge.smokestack.jms.ex04;

import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mockit.Expectations;
import mockit.Mocked;
import net.sourceforge.smokestack.jms.MockConnectionFactory;
import net.sourceforge.smokestack.jms.MockMessage;
import net.sourceforge.smokestack.jms.MockMessageConsumer;
import net.sourceforge.smokestack.jms.MockTextMessage;
import net.sourceforge.smokestack.jms.MockTopic;

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
			@Mocked( methods= {"receive"})
			MockMessageConsumer c;
			{
				c.receive(); returns(new MockTextMessage("Message 1"));
				c.receive(); returns(new MockMessage());
				c.receive(); returns(new MockTextMessage("Message 3"));
			}
		};
		
		DurableSubscriber.main(new String[]{"topic", "3"});
		cf.assertMockComplete();
		c.close();
	}

}
