/**
 * 
 */
package com.github.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

import com.github.smokestack.exception.NeedsMockDefinitionException;

import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockQueueBrowser implements QueueBrowser {

	protected String messageSelector;
	
	protected Queue queue;

	public enum QueueBrowserState {NEW, CLOSE};

	protected QueueBrowserState mockState=QueueBrowserState.NEW;

	public MockQueueBrowser(Queue queue) {
		this.queue=queue;
	}

	/* (non-Javadoc)
	 * @see javax.jms.QueueBrowser#close()
	 */
	public void close() throws JMSException {
		_close();
	}

	public void _close() throws JMSException {
		mockState=QueueBrowserState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.jms.QueueBrowser#getEnumeration()
	 */
	public Enumeration getEnumeration() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(QueueBrowserState.CLOSE));
		return _getEnumeration();
	}

	public Enumeration _getEnumeration() throws JMSException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.QueueBrowser#getMessageSelector()
	 */
	public String getMessageSelector() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(QueueBrowserState.CLOSE));
		return _getMessageSelector();
	}

	public String _getMessageSelector() throws JMSException {
		return messageSelector;
	}

	/* (non-Javadoc)
	 * @see javax.jms.QueueBrowser#getQueue()
	 */
	public Queue getQueue() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(QueueBrowserState.CLOSE));
		return _getQueue();
	}
	
	public Queue _getQueue() throws JMSException {
		return queue;
	}
}
