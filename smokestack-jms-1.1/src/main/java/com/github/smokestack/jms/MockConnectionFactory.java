/**
 * 
 */
package com.github.smokestack.jms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author gliptak
 *
 */
public class MockConnectionFactory implements ConnectionFactory, Serializable, Referenceable {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = 6306518344076861095L;

	protected List<MockConnection> mockConnections=new ArrayList<MockConnection>();
	
	protected Reference reference;

	/**
	 * Constructor
	 */
	public MockConnectionFactory() {
	}

	/* (non-Javadoc)
	 * @see javax.jms.ConnectionFactory#createConnection()
	 */
	public Connection createConnection() throws JMSException {
		_createConnection();
		MockConnection c=new MockConnection();
		mockConnections.add(c);
		return c;
	}

	public Connection _createConnection() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.ConnectionFactory#createConnection(java.lang.String, java.lang.String)
	 */
	public Connection createConnection(String userName, String password) throws JMSException {
		_createConnection(userName, password);
		MockConnection c=new MockConnection(userName, password);
		mockConnections.add(c);
		return c;
	}

	public Connection _createConnection(String userName, String password) throws JMSException {
		return null;
	}

	/**
	 * Validation
	 */
	public void assertMockComplete() {
		for (MockConnection c: mockConnections){
			c.assertMockComplete();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		for (MockConnection c: mockConnections){
			c.assertMockCommit();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		for (MockConnection c: mockConnections){
			c.assertMockRollback();
		}
	}

	/**
	 * @return the mockConnections
	 */
	public List<MockConnection> getMockConnections() {
		return mockConnections;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		return reference;
	}

	/**
	 * Making a setter available
	 * @param reference
	 */
	public void setReference(Reference reference){
		this.reference=reference;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
