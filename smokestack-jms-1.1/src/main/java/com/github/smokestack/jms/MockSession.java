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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockSession implements Session {

	protected boolean transacted;
	
	protected int acknowledgeMode;
	
	public enum SessionState {NEW, CLOSE};
	protected SessionState mockSessionState=SessionState.NEW;

	public enum TransactionState {NEW, ROLLBACK, COMMIT};
	public TransactionState mockTransactionState=TransactionState.NEW;

	protected List<MockMessageProducer> mockMessageProducers=new ArrayList<MockMessageProducer>();
	
	protected List<MockMessageConsumer> mockMessageConsumers=new ArrayList<MockMessageConsumer>();

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
		_close();
		mockSessionState=SessionState.CLOSE;
		// propagate
		for (MockMessageConsumer c: mockMessageConsumers){
			c.close();
		}
		// propagate
		for (MockMessageProducer p: mockMessageProducers){
			p.close();
		}
	}

	public void _close() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#commit()
	 */
	public void commit() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		try{
			_commit();
			mockTransactionState=TransactionState.COMMIT;
		}catch (JMSException je){
			mockTransactionState=TransactionState.ROLLBACK;
		}
	}

	public void _commit() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBrowser(javax.jms.Queue)
	 */
	public QueueBrowser createBrowser(Queue queue) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createBrowser(queue);
		MockQueueBrowser c=new MockQueueBrowser(queue);
		mockQueueBrowsers.add(c);
		return c;
	}

	public QueueBrowser _createBrowser(Queue queue) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBrowser(javax.jms.Queue, java.lang.String)
	 */
	public QueueBrowser createBrowser(Queue queue, String messageSelector) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createBrowser(queue, messageSelector);
	}

	public QueueBrowser _createBrowser(Queue queue, String messageSelector) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createBytesMessage()
	 */
	public BytesMessage createBytesMessage() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createBytesMessage();
	}

	public BytesMessage _createBytesMessage() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination)
	 */
	public MessageConsumer createConsumer(Destination destination) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createConsumer(destination);
		MockMessageConsumer c=new MockMessageConsumer(destination);
		mockMessageConsumers.add(c);
		return c;
	}

	public MessageConsumer _createConsumer(Destination destination) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination, java.lang.String)
	 */
	public MessageConsumer createConsumer(Destination destination, String messageSelector) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createConsumer(destination, messageSelector);
		MockMessageConsumer c=new MockMessageConsumer(destination, messageSelector);
		mockMessageConsumers.add(c);
		return c;
	}

	public MessageConsumer _createConsumer(Destination destination, String messageSelector) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createConsumer(javax.jms.Destination, java.lang.String, boolean)
	 */
	public MessageConsumer createConsumer(Destination destination, String messageSelector, boolean NoLocal) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createConsumer(destination, messageSelector, NoLocal);
		MockMessageConsumer c=new MockMessageConsumer(destination, messageSelector, NoLocal);
		mockMessageConsumers.add(c);
		return c;
	}

	public MessageConsumer _createConsumer(Destination destination, String messageSelector, boolean NoLocal) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableSubscriber(javax.jms.Topic, java.lang.String)
	 */
	public TopicSubscriber createDurableSubscriber(Topic topic, String name) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createDurableSubscriber(topic, name);
		MockTopicSubscriber ts=new MockTopicSubscriber(topic, name);
		mockMessageConsumers.add(ts);
		return ts;
	}

	public TopicSubscriber _createDurableSubscriber(Topic topic, String name) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createDurableSubscriber(javax.jms.Topic, java.lang.String, java.lang.String, boolean)
	 */
	public TopicSubscriber createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createDurableSubscriber(topic, name, messageSelector, noLocal);
	}

	public TopicSubscriber _createDurableSubscriber(Topic topic, String name, String messageSelector, boolean noLocal) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createMapMessage()
	 */
	public MapMessage createMapMessage() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createMapMessage();
	}

	public MapMessage _createMapMessage() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createMessage()
	 */
	public Message createMessage() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createMessage();
		MockMessage m=new MockMessage();
		mockMessages.add(m);
		return m;
	}

	public Message _createMessage() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createObjectMessage()
	 */
	public ObjectMessage createObjectMessage() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createObjectMessage();
	}

	public ObjectMessage _createObjectMessage() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createObjectMessage(java.io.Serializable)
	 */
	public ObjectMessage createObjectMessage(Serializable arg0) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createObjectMessage(arg0);
	}

	public ObjectMessage _createObjectMessage(Serializable arg0) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createProducer(javax.jms.Destination)
	 */
	public MessageProducer createProducer(Destination destination) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createProducer(destination);
		MockMessageProducer p=new MockMessageProducer(destination);
		mockMessageProducers.add(p);
		return p;
	}

	public MessageProducer _createProducer(Destination destination) throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createQueue(java.lang.String)
	 */
	public Queue createQueue(String arg0) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createQueue(arg0);
	}

	public Queue _createQueue(String arg0) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createStreamMessage()
	 */
	public StreamMessage createStreamMessage() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createStreamMessage();
	}

	public StreamMessage _createStreamMessage() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTemporaryQueue()
	 */
	public TemporaryQueue createTemporaryQueue() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createTemporaryQueue();
	}

	public TemporaryQueue _createTemporaryQueue() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTemporaryTopic()
	 */
	public TemporaryTopic createTemporaryTopic() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createTemporaryTopic();
	}

	public TemporaryTopic _createTemporaryTopic() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTextMessage()
	 */
	public TextMessage createTextMessage() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_createTextMessage();
		MockTextMessage m=new MockTextMessage();
		mockMessages.add(m);
		return m;
	}

	public TextMessage _createTextMessage() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTextMessage(java.lang.String)
	 */
	public TextMessage createTextMessage(String text) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createTextMessage(text);
	}

	public TextMessage _createTextMessage(String text) throws JMSException {
		return new MockTextMessage(text);
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#createTopic(java.lang.String)
	 */
	public Topic createTopic(String arg0) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		return _createTopic(arg0);
	}

	public Topic _createTopic(String arg0) throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getAcknowledgeMode()
	 */
	public int getAcknowledgeMode() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_getAcknowledgeMode();
		return acknowledgeMode;
	}

	public int _getAcknowledgeMode() throws JMSException {
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getMessageListener()
	 */
	public MessageListener getMessageListener() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_getMessageListener();
		return messageListener;
	}

	public MessageListener _getMessageListener() throws JMSException {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#getTransacted()
	 */
	public boolean getTransacted() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_getTransacted();
		return transacted;
	}

	public boolean _getTransacted() throws JMSException {
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#recover()
	 */
	public void recover() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_recover();
	}

	public void _recover() throws JMSException {
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#rollback()
	 */
	public void rollback() throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_rollback();
		mockTransactionState=TransactionState.ROLLBACK;
	}

	public void _rollback() throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#run()
	 */
	public void run() {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_run();
	}

	public void _run() {
	}

	/* (non-Javadoc)
.	 * @see javax.jms.Session#setMessageListener(javax.jms.MessageListener)
	 */
	public void setMessageListener(MessageListener messageListener) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_setMessageListener(messageListener);
		this.messageListener=messageListener;
	}

	public void _setMessageListener(MessageListener messageListener) throws JMSException {
	}

	/* (non-Javadoc)
	 * @see javax.jms.Session#unsubscribe(java.lang.String)
	 */
	public void unsubscribe(String arg0) throws JMSException {
		assertThat(mockSessionState, IsNot.not(SessionState.CLOSE));
		_unsubscribe(arg0);
	}

	public void _unsubscribe(String arg0) throws JMSException {
		throw new NotYetImplementedException();
	}

	/**
	 * Validation
	 */
	public void assertMockComplete() {
		assertThat(mockSessionState, Is.is(SessionState.CLOSE));
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertThat(mockTransactionState, Is.is(TransactionState.COMMIT));
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertThat(mockTransactionState, Is.is(TransactionState.ROLLBACK));
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
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
