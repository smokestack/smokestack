/**
 * 
 */
package com.github.smokestack.jms;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import com.github.smokestack.exception.NotYetImplementedException;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockSession implements Session {

	protected boolean transacted;
	
	protected int acknowledgeMode;
	
	public enum SessionState {NEW, COMMIT, ROLLBACK, CLOSE};
	
	protected SessionState mockState=SessionState.NEW;
	
	protected List<MockMessageProducer> mockMessageProducers=new ArrayList<MockMessageProducer>();
	
	protected List<MockMessageConsumer> mockMessageConsumers=new ArrayList<MockMessageConsumer>();

	private boolean committed=false;

	private boolean rolledBack=false;

	private MessageListener messageListener;

	protected List<MockQueueBrowser> mockQueueBrowsers=new ArrayList<MockQueueBrowser>();

	protected List<MockMessage> mockMessages=new ArrayList<MockMessage>();

	public MockSession(boolean transacted, int acknowledgeMode) {
		this.transacted=transacted;
		this.acknowledgeMode=acknowledgeMode;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#close()
	 */
	public void close() throws JMSException {
		mockState=SessionState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#commit()
	 */
	public void commit() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		committed=true;
		mockState=SessionState.COMMIT;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBrowser(javax.jms.Queue)
	 */
	public QueueBrowser createBrowser(Queue queue) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockQueueBrowser c=new MockQueueBrowser(queue);
		mockQueueBrowsers.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBrowser(javax.jms.Queue, java.lang.String)
	 */
	public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBytesMessage()
	 */
	public BytesMessage createBytesMessage() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination)
	 */
	public MessageConsumer createConsumer(Destination destination) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockMessageConsumer c=new MockMessageConsumer(destination);
		mockMessageConsumers.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination, java.lang.String)
	 */
	public MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockMessageConsumer c=new MockMessageConsumer(destination, messageSelector);
		mockMessageConsumers.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination, java.lang.String, boolean)
	 */
	public MessageConsumer createConsumer(Destination destination, String messageSelector, boolean NoLocal) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockMessageConsumer c=new MockMessageConsumer(destination, messageSelector, NoLocal);
		mockMessageConsumers.add(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableSubscriber(javax.jms.Topic, java.lang.String)
	 */
	public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockTopicSubscriber ts=new MockTopicSubscriber(topic, name);
		mockMessageConsumers.add(ts);
		return ts;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableSubscriber(javax.jms.Topic, java.lang.String, java.lang.String, boolean)
	 */
	public TopicSubscriber createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createMapMessage()
	 */
	public MapMessage createMapMessage() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createMessage()
	 */
	public Message createMessage() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockMessage m=new MockMessage();
		mockMessages.add(m);
		return m;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createObjectMessage()
	 */
	public ObjectMessage createObjectMessage() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createObjectMessage(java.io.Serializable)
	 */
	public ObjectMessage createObjectMessage(Serializable arg0) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createProducer(javax.jms.Destination)
	 */
	public MessageProducer createProducer(Destination destination) throws JMSException {
		MockMessageProducer p=new MockMessageProducer(destination);
		mockMessageProducers.add(p);
		return p;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createQueue(java.lang.String)
	 */
	public Queue createQueue(String arg0) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createStreamMessage()
	 */
	public StreamMessage createStreamMessage() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTemporaryQueue()
	 */
	public TemporaryQueue createTemporaryQueue() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTemporaryTopic()
	 */
	public TemporaryTopic createTemporaryTopic() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTextMessage()
	 */
	public TextMessage createTextMessage() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		MockTextMessage m=new MockTextMessage();
		mockMessages.add(m);
		return m;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTextMessage(java.lang.String)
	 */
	public TextMessage createTextMessage(String text) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		return new MockTextMessage(text);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTopic(java.lang.String)
	 */
	public Topic createTopic(String arg0) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getAcknowledgeMode()
	 */
	public int getAcknowledgeMode() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		return acknowledgeMode;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getMessageListener()
	 */
	public MessageListener getMessageListener() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		return messageListener;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getTransacted()
	 */
	public boolean getTransacted() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		return transacted;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#recover()
	 */
	public void recover() throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#rollback()
	 */
	public void rollback() throws JMSException {
		this.rolledBack=true;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#run()
	 */
	public void run() {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
	}

	/* (non-Javadoc)
.	 * @see javax.jms.Session#setMessageListener(javax.jms.MessageListener)
	 */
	public void setMessageListener(MessageListener messageListener) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		this.messageListener=messageListener;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#unsubscribe(java.lang.String)
	 */
	public void unsubscribe(String arg0) throws JMSException {
		assertThat("mockState", mockState, IsNot.not(SessionState.CLOSE));
		throw new NotYetImplementedException();
	}

	/**
	 * Validation
	 */
	public void assertMockComplete() {
//		assertThat("mockState", mockState, IsNot.not(SessionState.NEW));
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertMockComplete();
		assertThat("committed", committed, Is.is(true));
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertMockComplete();
		assertThat("rolledBack", rolledBack, Is.is(true));
	}

	/**
	 * @return the mockMessageProducers
	 */
	public List<MockMessageProducer> getMockMessageProducers() {
		return mockMessageProducers;
	}

	/**
	 * @return the mockMessageConsumers
	 */
	public List<MockMessageConsumer> getMockMessageConsumers() {
		return mockMessageConsumers;
	}

	/**
	 * @return the mockMessages
	 */
	public List<MockMessage> getMockMessages() {
		return mockMessages;
	}

}
