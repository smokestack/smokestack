package com.github.smokestack.jca.cci;

import static org.hamcrest.MatcherAssert.assertThat;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Interaction;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;
import javax.resource.cci.ResourceWarning;

import com.github.smokestack.exception.NeedsMockDefinitionException;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.Is;

public class MockInteraction implements Interaction {

	protected MockConnection mockConnection;

	public enum InteractionState {NEW, CLOSE};
	
	protected InteractionState interactionState=InteractionState.NEW;
	
	protected ResourceWarning resourceWarning=null;

	public MockInteraction(MockConnection mockConnection) {
		this.mockConnection=mockConnection;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#clearWarnings()
	 */
	public void clearWarnings() throws ResourceException {
		resourceWarning=null;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#close()
	 */
	public void close() throws ResourceException {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		interactionState=InteractionState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec, javax.resource.cci.Record)
	 */
	public Record execute(InteractionSpec interactionSpec, Record arg1) throws ResourceException {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec, javax.resource.cci.Record, javax.resource.cci.Record)
	 */
	public boolean execute(InteractionSpec interactionSpec, Record arg1, Record arg2) throws ResourceException {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#getConnection()
	 */
	public Connection getConnection() {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		return mockConnection;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#getWarnings()
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return resourceWarning;
	}
	
	public InteractionState getMockInteractionState() {
		return interactionState;
	}
	
	public void validateMockComplete(){
		assertThat("connectionState", interactionState, Is.is(InteractionState.CLOSE));	
	}

	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
