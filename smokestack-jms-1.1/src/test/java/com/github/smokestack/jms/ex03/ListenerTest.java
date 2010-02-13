package com.github.smokestack.jms.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jms.MockConnection;
import com.github.smokestack.jms.MockConnectionFactory;
import com.github.smokestack.jms.MockMessageConsumer;
import com.github.smokestack.jms.MockQueue;
import com.github.smokestack.jms.MockSession;
import com.github.smokestack.jms.MockTextMessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ListenerTest {

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
	public final void testMain() throws NamingException, JMSException, IOException {
		Context c=new InitialContext();
		final MockConnectionFactory cf=new MockConnectionFactory();
		c.bind("ConnectionFactory", cf);
		c.bind("queue", new MockQueue("queue"));

		new Expectations(){
			@Mocked( methods= {"_start"})
			MockConnection c;
			@Mocked
			BufferedReader br;
			{
				c._start();
				returns(new Delegate(){
					@SuppressWarnings("unused")
					void start() throws JMSException {
						MockSession s=cf.getMockConnections().get(0).getMockSessions().get(0);
						MockMessageConsumer c=s.getMockMessageConsumers().get(0);
						c.getMessageListener().onMessage(new MockTextMessage("on 1"));
						c.getMessageListener().onMessage(new MockTextMessage("on 2"));
					}
				});
				new BufferedReader(withInstanceOf(InputStreamReader.class));
				br.readLine(); returns("\n");
			}
		};
		Listener.main(new String[]{"queue"});
		cf.assertMockComplete();
		c.close();
	}
}
