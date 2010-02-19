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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
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
		mockState=QueueBrowserState.CLOSE;
	}

	public void _close() throws JMSException {
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
		_getMessageSelector();
		return messageSelector;
	}

	public String _getMessageSelector() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.QueueBrowser#getQueue()
	 */
	public Queue getQueue() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(QueueBrowserState.CLOSE));
		_getQueue();
		return queue;
	}
	
	public Queue _getQueue() throws JMSException {
		return null;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
