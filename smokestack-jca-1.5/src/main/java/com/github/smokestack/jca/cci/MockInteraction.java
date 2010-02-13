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
		_clearWarnings();
	}

	public void _clearWarnings() throws ResourceException {
		resourceWarning=null;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#close()
	 */
	public void close() throws ResourceException {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		_close();
	}

	public void _close() throws ResourceException {
		interactionState=InteractionState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec, javax.resource.cci.Record)
	 */
	public Record execute(InteractionSpec interactionSpec, Record record) throws ResourceException {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		return _execute(interactionSpec, record);
	}

	public Record _execute(InteractionSpec interactionSpec, Record record) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#execute(javax.resource.cci.InteractionSpec, javax.resource.cci.Record, javax.resource.cci.Record)
	 */
	public boolean execute(InteractionSpec interactionSpec, Record record1, Record record2) throws ResourceException {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		return _execute(interactionSpec, record1, record2);
	}

	public boolean _execute(InteractionSpec interactionSpec, Record record1, Record record2) throws ResourceException {
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#getConnection()
	 */
	public Connection getConnection() {
		assertThat("interactionState", interactionState, Is.is(InteractionState.NEW));
		return _getConnection();
	}

	public Connection _getConnection() {
		return mockConnection;
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Interaction#getWarnings()
	 */
	public ResourceWarning getWarnings() throws ResourceException {
		return _getWarnings();
	}
	
	public ResourceWarning _getWarnings() throws ResourceException {
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
