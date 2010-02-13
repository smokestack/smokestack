/**
 * 
 */
package com.github.smokestack.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @author gliptak
 *
 */
public class MockTextMessage extends MockMessage implements TextMessage {

	protected String text;

	public MockTextMessage(String text) {
		this.text=text;
	}

	public MockTextMessage() {
		this("");
	}

	/* (non-Javadoc)
	 * @see javax.jms.TextMessage#getText()
	 */
	public String getText() throws JMSException {
		return text;
	}

	/* (non-Javadoc)
	 * @see javax.jms.TextMessage#setText(java.lang.String)
	 */
	public void setText(String text) throws JMSException {
		this.text=text;
	}
}
