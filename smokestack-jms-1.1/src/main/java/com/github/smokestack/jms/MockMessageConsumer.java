/**
 * 
 */
package com.github.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.IsNot;

import com.github.smokestack.exception.NeedsMockDefinitionException;

/**
 * @author gliptak
 *
 */
public class MockMessageConsumer implements MessageConsumer {

	protected Destination destination;

	public enum MessageConsumerState {NEW, CLOSE};

	protected MessageConsumerState mockState=MessageConsumerState.NEW;
	
	protected String messageSelector;
	
	protected MessageListener messageListener;

	protected boolean NoLocal;

	public MockMessageConsumer(Destination destination) {
		this.destination=destination;
	}

	public MockMessageConsumer(Destination destination, String messageSelector) {
		this.destination=destination;
		this.messageSelector=messageSelector;
	}

	public MockMessageConsumer(Destination destination,	String messageSelector, boolean NoLocal) {
		this.destination=destination;
		this.messageSelector=messageSelector;
		this.NoLocal=NoLocal;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#close()
	 */
	public void close() throws JMSException {
		_close();
		mockState=MessageConsumerState.CLOSE;
	}

	public void _close() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#getMessageListener()
	 */
	public MessageListener getMessageListener() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		_getMessageListener();
		return messageListener;
	}

	public MessageListener _getMessageListener() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#getMessageSelector()
	 */
	public String getMessageSelector() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		_getMessageSelector();
		return messageSelector;
	}

	public String _getMessageSelector() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receive()
	 */
	public Message receive() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		return _receive();
	}

	public Message _receive() throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receive(long)
	 */
	public Message receive(long timeout) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		return _receive(timeout);
	}

	public Message _receive(long timeout) throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receiveNoWait()
	 */
	public Message receiveNoWait() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		return _receiveNoWait();
	}

	public Message _receiveNoWait() throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#setMessageListener(javax.jms.MessageListener)
	 */
	public void setMessageListener(MessageListener messageListener) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		_setMessageListener(messageListener);	
		this.messageListener=messageListener;	
	}

	public void _setMessageListener(MessageListener messageListener) throws JMSException {
	}

	/**
	 * @return the mockState
	 */
	public MessageConsumerState getMockState() {
		return mockState;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
