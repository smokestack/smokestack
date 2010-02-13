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
		mockState=MessageConsumerState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#getMessageListener()
	 */
	public MessageListener getMessageListener() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		return messageListener;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#getMessageSelector()
	 */
	public String getMessageSelector() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		return messageSelector;
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receive()
	 */
	public Message receive() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receive(long)
	 */
	public Message receive(long timeout) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#receiveNoWait()
	 */
	public Message receiveNoWait() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.MessageConsumer#setMessageListener(javax.jms.MessageListener)
	 */
	public void setMessageListener(MessageListener messageListener) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		this.messageListener=messageListener;	
	}

	/**
	 * @return the mockState
	 */
	public MessageConsumerState getMockState() {
		return mockState;
	}

}
