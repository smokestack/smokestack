/**
 * 
 */
package com.github.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import javax.jms.JMSException;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockTopicSubscriber extends MockMessageConsumer implements
		TopicSubscriber {

	public MockTopicSubscriber(Topic topic, String name) {
		super(topic, name);
	}

	/* (non-Javadoc)
	 * @see javax.jms.TopicSubscriber#getNoLocal()
	 */
	public boolean getNoLocal() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		_getNoLocal();
		return NoLocal;
	}

	public boolean _getNoLocal() throws JMSException {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.TopicSubscriber#getTopic()
	 */
	public Topic getTopic() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(MessageConsumerState.CLOSE));
		_getTopic();
		return (Topic)destination;
	}

	public Topic _getTopic() throws JMSException {
		return null;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
