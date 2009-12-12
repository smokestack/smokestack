package net.sourceforge.smokestack.jms;

import static org.junit.Assert.fail;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Topic;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockMessageTest {

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
	public void testProperties() throws JMSException{
		MockMessage m=new MockMessage();
		m.setBooleanProperty("boolean", true);
		m.setByteProperty("byte", (byte)1);
        m.setDoubleProperty("double", 2.0d);
        m.setFloatProperty("float", 3.0f);        
        m.setIntProperty("integer", 4);
        m.setLongProperty("long", 5l);
		m.setObjectProperty("goodobject", "JustAString");
		try {
			m.setObjectProperty("badobject", new Object());
			fail("expected AssertionError");			
		} catch (AssertionError ae) {
			// IGNORE
		}
        m.setShortProperty("short", (short)6);
        m.setStringProperty("string", "JustAnotherString");
        
        assertThat(m.getBooleanProperty("boolean"), Is.is(true));
        assertThat(m.getByteProperty("byte"), Is.is((byte)1));
        assertThat(m.getDoubleProperty("double"), Is.is(2.0d));
        assertThat(m.getFloatProperty("float"), Is.is(3.0f));
        assertThat(m.getIntProperty("integer"), Is.is(4));
        assertThat(m.getLongProperty("long"), Is.is(5l));
        assertThat((String)m.getObjectProperty("goodobject"), Is.is("JustAString"));
        assertThat(m.propertyExists("badobject"), Is.is(false));
        assertThat(m.getShortProperty("short"), Is.is((short)6));
        assertThat(m.getStringProperty("string"), Is.is("JustAnotherString"));
        
        assertThat(m.getPropertyNames().hasMoreElements(), Is.is(true));
        
        m.clearProperties();
        assertThat(m.propertyExists("goodobject"), Is.is(false));        
	}
	
	@Test
	public void testHeaders() throws JMSException{
		MockMessage m=new MockMessage();
		
		try {
			m.getJMSCorrelationID();
			fail("expected JMSException");			
		} catch (JMSException jmse) {
			// IGNORE
		}
		m.setJMSCorrelationID("654321");
		assertThat(m.getJMSCorrelationID(), Is.is("654321"));

		byte[] b=new byte[]{(byte)0x10, (byte)0x11, (byte)0x12};
		m.setJMSCorrelationIDAsBytes(b);
		assertThat(m.getJMSCorrelationIDAsBytes(), Is.is(b));

		m.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
		assertThat(m.getJMSDeliveryMode(), Is.is(DeliveryMode.PERSISTENT));
		
		Topic d1=new MockTopic("topicName");
		m.setJMSDestination(d1);
		assertThat((Topic)m.getJMSDestination(), Is.is(d1));

		long expiry=System.currentTimeMillis();
		m.setJMSExpiration(expiry);
		assertThat(m.getJMSExpiration(), Is.is(expiry));

		m.setJMSMessageID("ID:foo");
		assertThat(m.getJMSMessageID(), Is.is("ID:foo"));

		try {
			m.setJMSPriority(-999);
			fail("expected AssertionError");			
		} catch (AssertionError ae) {
			// IGNORE
		}
        m.setJMSPriority(5);
        assertThat(m.getJMSPriority(), Is.is(5));
        
        m.setJMSRedelivered(true);
        assertThat(m.getJMSRedelivered(), Is.is(true));

		Destination d2=new MockQueue("queueName");        
        m.setJMSReplyTo(d2);
        assertThat(m.getJMSReplyTo(), Is.is(d2));

        long now=System.currentTimeMillis();
        m.setJMSTimestamp(now);
        assertThat(m.getJMSTimestamp(), Is.is(now));

        m.setJMSType("type");
        assertThat(m.getJMSType(), Is.is("type"));
	}
}
