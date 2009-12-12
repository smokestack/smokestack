/**
 * 
 */
package net.sourceforge.smokestack.jms;

import javax.jms.JMSException;
import javax.jms.Topic;

/**
 * @author gliptak
 *
 */
public class MockTopic implements Topic {
	
	protected String topicName;

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
		return topicName;
	}

}
