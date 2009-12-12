/**
 * 
 */
package net.sourceforge.smokestack.jms;

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

import net.sourceforge.smokestack.exception.NotYetImplementedException;

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
		mockState=ConnectionState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createConnectionConsumer(javax.jms.Destination, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	public ConnectionConsumer createConnectionConsumer(Destination destination, String messageSelector,
			ServerSessionPool sessionPool, int maxMessages) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createDurableConnectionConsumer(javax.jms.Topic, java.lang.String, java.lang.String, javax.jms.ServerSessionPool, int)
	 */
	public ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, 
			String messageSelector, ServerSessionPool sessionPool, int maxMessages)	throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#createSession(boolean, int)
	 */
	public Session createSession(boolean transacted, int acknowledgeMode) throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		MockSession s=new MockSession(transacted, acknowledgeMode);
		mockSessions.add(s);
		return s;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getClientID()
	 */
	public String getClientID() throws JMSException {
		return clientID;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getExceptionListener()
	 */
	public ExceptionListener getExceptionListener() throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws JMSException {
		return new MockConnectionMetaData();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#setClientID(java.lang.String)
	 */
	public void setClientID(String clientID) throws JMSException {
      	this.clientID=clientID;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#setExceptionListener(javax.jms.ExceptionListener)
	 */
	public void setExceptionListener(ExceptionListener listener) throws JMSException {
        assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#start()
	 */
	public void start() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(ConnectionState.CLOSE));
		mockState=ConnectionState.START;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Connection#stop()
	 */
	public void stop() throws JMSException {
		assertThat("mockState", mockState, Is.is(ConnectionState.START));
		mockState=ConnectionState.STOP;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
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
}
