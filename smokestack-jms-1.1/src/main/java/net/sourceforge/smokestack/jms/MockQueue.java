/**
 * 
 */
package net.sourceforge.smokestack.jms;

import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * @author gliptak
 *
 */
public class MockQueue implements Queue {
	
	protected String queueName;

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
		return queueName;
	}

}
