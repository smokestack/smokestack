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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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
		_getQueueName();
		return queueName;
	}

	public String _getQueueName() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.naming.Referenceable#getReference()
	 */
	public Reference getReference() throws NamingException {
		_getReference();
		return reference;
	}

	public Reference _getReference() throws NamingException {
		return null;
	}

	/**
	 * Making a setter available
	 * @param reference
	 */
	public void setReference(Reference reference){
		_setReference(reference);
		this.reference=reference;
	}
	
	public void _setReference(Reference reference){
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
