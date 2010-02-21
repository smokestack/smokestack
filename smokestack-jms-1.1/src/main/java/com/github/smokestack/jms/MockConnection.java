/**
 * 
 */
package com.github.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;

import com.github.smokestack.exception.NotYetImplementedException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockConnection implements Connection {

	public enum ConnectionState {NEW, START, STOP, CLOSE};

	protected ConnectionState mockState=ConnectionState.NEW;

	protected String userName;
	protected String password;
	protected String clientID="";
	protected List<MockSession> mockSessions=new ArrayList<MockSession>();

	public MockConnection(String userName, String password) {
		this.userName=userName;
		this.password=password;
	}

	public MockConnection() {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#close()
	 */
	public void close() throws JMSException {
		_close();
		mockState=ConnectionState.CLOSE;
		// propagate
		for (MockSession session: mockSessions){
			session.close();
		}
	}

	public void _close() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createConnectionConsumer(javax.jms.Destination, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		return _createConnectionConsumer(destination, messageSelector, sessionPool, maxMessages);
	}

	public ConnectionConsumer _createConnectionConsumer(Destination destination, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createDurableConnectionConsumer(javax.jms.Topic, java.lang.String, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, 
			String messageSelector, ServerSessionPool sessionPool, int maxMessages)	throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		return _createDurableConnectionConsumer(topic, subscriptionName, messageSelector, sessionPool, maxMessages);
	}

	public ConnectionConsumer _createDurableConnectionConsumer(Topic topic, String subscriptionName, 
			String messageSelector, ServerSessionPool sessionPool, int maxMessages)	throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSession(boolean, int)
	 */
	public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		_createSession(transacted, acknowledgeMode);
		MockSession s=new MockSession(transacted, acknowledgeMode);
		mockSessions.add(s);
		return s;
	}

	public Session _createSession(boolean transacted, int acknowledgeMode) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getClientID()
	 */
	public String getClientID() throws JMSException {
		_getClientID();
		return clientID;
	}

	public String _getClientID() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getExceptionListener()
	 */
	public ExceptionListener getExceptionListener() throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		return _getExceptionListener();
	}

	public ExceptionListener _getExceptionListener() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws JMSException {
		return _getMetaData();
	}

	public ConnectionMetaData _getMetaData() throws JMSException {
		return new MockConnectionMetaData();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#setClientID(java.lang.String)
	 */
	public void setClientID(String clientID) throws JMSException {
      	_setClientID(clientID);
      	this.clientID=clientID;
	}

	public void _setClientID(String clientID) throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#setExceptionListener(javax.jms.ExceptionListener)
	 */
	public void setExceptionListener(ExceptionListener listener) throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		_setExceptionListener(listener);
	}

	public void _setExceptionListener(ExceptionListener listener) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#start()
	 */
	public void start() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		_start();
		mockState=ConnectionState.START;
	}

	public void _start() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#stop()
	 */
	public void stop() throws JMSException {
		assertThat("mockState", mockState, Is.is(ConnectionState.START));
		_stop();
		mockState=ConnectionState.STOP;
	}

	public void _stop() throws JMSException {
	}

	/**
	 * Validation
	 */
	public void assertMockComplete() {
		assertThat("mockState", mockState, Is.is(ConnectionState.CLOSE));
		for (MockSession s: mockSessions){
			s.assertMockComplete();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertThat("mockState", mockState, Is.is(ConnectionState.CLOSE));
		for (MockSession s: mockSessions){
			s.assertMockCommit();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertThat("mockState", mockState, Is.is(ConnectionState.CLOSE));
		for (MockSession s: mockSessions){
			s.assertMockRollback();
		}
	}

	/**
	 * @return the mockState
	 */
	public ConnectionState getMockState() {
		return mockState;
	}

	/**
	 * @return the mockSessions
	 */
	public List<MockSession> getMockSessions() {
		return mockSessions;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
