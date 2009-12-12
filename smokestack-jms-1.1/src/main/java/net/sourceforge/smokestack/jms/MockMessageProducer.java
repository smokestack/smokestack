/**
 * 
 */
package net.sourceforge.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import net.sourceforge.smokestack.exception.NeedsMockDefinitionException;

import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockMessageProducer implements MessageProducer {

	protected Destination destination;

	public enum MessageProducerState {NEW, CLOSE};

	protected MessageProducerState mockState=MessageProducerState.NEW;

	protected int deliveryMode;

	protected boolean disableMessageID;

	protected boolean disableMessageTimestamp;

	protected int priority;

	protected long timeToLive;

	public MockMessageProducer(Destination destination) {
		this.destination=destination;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#close()
	 */
	public void close() throws JMSException {
		mockState=MessageProducerState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDeliveryMode()
	 */
	public int getDeliveryMode() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		return deliveryMode;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDestination()
	 */
	public Destination getDestination() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		return destination;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDisableMessageID()
	 */
	public boolean getDisableMessageID() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		return disableMessageID;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDisableMessageTimestamp()
	 */
	public boolean getDisableMessageTimestamp() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		return disableMessageTimestamp;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getPriority()
	 */
	public int getPriority() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		return priority;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getTimeToLive()
	 */
	public long getTimeToLive() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		return timeToLive;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Message)
	 */
	public void send(Message message) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination, javax.jms.Message)
	 */
	public void send(Destination destination, Message message) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Message, int, int, long)
	 */
	public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination, javax.jms.Message, int, int, long)
	 */
	public void send(Destination destination, Message message, int deliveryMode, int priority,
			long timeToLive) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setDeliveryMode(int)
	 */
	public void setDeliveryMode(int deliveryMode) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		this.deliveryMode=deliveryMode;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setDisableMessageID(boolean)
	 */
	public void setDisableMessageID(boolean disableMessageID) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		this.disableMessageID=disableMessageID;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setDisableMessageTimestamp(boolean)
	 */
	public void setDisableMessageTimestamp(boolean disableMessageTimestamp) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		this.disableMessageTimestamp=disableMessageTimestamp;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setPriority(int)
	 */
	public void setPriority(int priority) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		this.priority=priority;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setTimeToLive(long)
	 */
	public void setTimeToLive(long timeToLive) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		this.timeToLive=timeToLive;
	}

	/**
	 * @return the mockState
	 */
	public MessageProducerState getMockState() {
		return mockState;
	}

}
