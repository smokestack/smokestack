/**
 * 
 */
package com.github.smokestack.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

/**
 * @author gliptak
 *
 */
public class MockQueue implements Queue, Serializable, Referenceable {
	
	/**
	 * Generated
	 */
	private static final long serialVersionUID = 2246186674052732637L;

	protected String queueName;
	
	protected Reference reference;

	/**
	 * @param queueName
	 */
	public MockQueue(String queueName) {
		super();
		this.queueName = queueName;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Queue#getQueueName()
	 */
	public String getQueueName() throws JMSException {
		return _getQueueName();
	}

	public String _getQueueName() throws JMSException {
		return queueName;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		return _getReference();
	}

	public Reference _getReference() throws NamingException {
		return reference;
	}

	/**
	 * Making a setter available
	 * @param reference
	 */
	public void setReference(Reference reference){
		_setReference(reference);
	}
	
	public void _setReference(Reference reference){
		this.reference=reference;
	}
}
