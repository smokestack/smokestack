/**
 * 
 */
package com.github.smokestack.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

/**
 * @author gliptak
 *
 */
public class MockTopic implements Topic, Serializable, Referenceable {
	
	/**
	 * Generated
	 */
	private static final long serialVersionUID = -6729071527792799643L;

	protected String topicName;

	protected Reference reference;

	/**
	 * @param topicName
	 */
	public MockTopic(String topicName) {
		super();
		this.topicName = topicName;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Topic#getTopicName()
	 */
	public String getTopicName() throws JMSException {
		return _getTopicName();
	}

	public String _getTopicName() throws JMSException {
		return topicName;
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
