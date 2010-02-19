/**
 * 
 */
package com.github.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import com.github.smokestack.exception.NeedsMockDefinitionException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
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
		_close();
		mockState=MessageProducerState.CLOSE;
	}

	public void _close() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDeliveryMode()
	 */
	public int getDeliveryMode() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_getDeliveryMode();
		return deliveryMode;
	}

	public int _getDeliveryMode() throws JMSException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDestination()
	 */
	public Destination getDestination() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_getDestination();
		return destination;
	}

	public Destination _getDestination() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDisableMessageID()
	 */
	public boolean getDisableMessageID() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_getDisableMessageID();
		return disableMessageID;
	}

	public boolean _getDisableMessageID() throws JMSException {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getDisableMessageTimestamp()
	 */
	public boolean getDisableMessageTimestamp() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_getDisableMessageTimestamp();
		return disableMessageTimestamp;
	}

	public boolean _getDisableMessageTimestamp() throws JMSException {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getPriority()
	 */
	public int getPriority() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_getPriority();
		return priority;
	}

	public int _getPriority() throws JMSException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#getTimeToLive()
	 */
	public long getTimeToLive() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_getTimeToLive();
		return timeToLive;
	}

	public long _getTimeToLive() throws JMSException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Message)
	 */
	public void send(Message message) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_send(message);
	}

	public void _send(Message message) throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination, javax.jms.Message)
	 */
	public void send(Destination destination, Message message) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_send(destination, message);
	}

	public void _send(Destination destination, Message message) throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Message, int, int, long)
	 */
	public void send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_send(message, deliveryMode, priority, timeToLive);
	}

	public void _send(Message message, int deliveryMode, int priority, long timeToLive) throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#send(javax.jms.Destination, javax.jms.Message, int, int, long)
	 */
	public void send(Destination destination, Message message, int deliveryMode, int priority,
			long timeToLive) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_send(message, deliveryMode, priority, timeToLive);
	}

	public void _send(Destination destination, Message message, int deliveryMode, int priority,
			long timeToLive) throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setDeliveryMode(int)
	 */
	public void setDeliveryMode(int deliveryMode) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_setDeliveryMode(deliveryMode);
		this.deliveryMode=deliveryMode;
	}

	public void _setDeliveryMode(int deliveryMode) throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setDisableMessageID(boolean)
	 */
	public void setDisableMessageID(boolean disableMessageID) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_setDisableMessageID(disableMessageID);
		this.disableMessageID=disableMessageID;
	}

	public void _setDisableMessageID(boolean disableMessageID) throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setDisableMessageTimestamp(boolean)
	 */
	public void setDisableMessageTimestamp(boolean disableMessageTimestamp) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_setDisableMessageTimestamp(disableMessageTimestamp);
		this.disableMessageTimestamp=disableMessageTimestamp;
	}

	public void _setDisableMessageTimestamp(boolean disableMessageTimestamp) throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setPriority(int)
	 */
	public void setPriority(int priority) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_setPriority(priority);
		this.priority=priority;
	}

	public void _setPriority(int priority) throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageProducer#setTimeToLive(long)
	 */
	public void setTimeToLive(long timeToLive) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageProducerState.CLOSE));
		_setTimeToLive(timeToLive);
		this.timeToLive=timeToLive;
	}

	public void _setTimeToLive(long timeToLive) throws JMSException {
	}

	/**
	 * @return the mockState
	 */
	public MessageProducerState getMockState() {
		return mockState;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
