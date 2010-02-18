package com.github.smokestack.jca.cci;

import static org.hamcrest.MatcherAssert.assertThat;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.Is;

public class MockConnection implements Connection {

	public enum ConnectionState {NEW, CLOSE};
	
	protected ConnectionState connectionState=ConnectionState.NEW;
	
	protected MockInteraction mockInteraction;
	protected MockLocalTransaction mockTransaction;
	protected ConnectionSpec connectionSpec;
	protected MockResultSetInfo mockResultSetInfo;
	protected MockConnectionMetaData mockConnectionMetaData;
	
	public MockConnection(ConnectionSpec connectionSpec) {
		this.connectionSpec=connectionSpec;
	}

	public MockConnection() {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#close()
	 */
	public void close() throws ResourceException {
		assertThat("connectionState", connectionState, Is.is(ConnectionState.NEW));
		connectionState=ConnectionState.CLOSE;
		_close();
	}

	public void _close() throws ResourceException {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#createInteraction()
	 */
	public Interaction createInteraction() throws ResourceException {
		assertThat("connectionState", connectionState, Is.is(ConnectionState.NEW));
		if (mockInteraction==null){
			mockInteraction=_createInteraction();
		}
		return mockInteraction;
	}

	public MockInteraction _createInteraction() throws ResourceException {
		return new MockInteraction(this);
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#getLocalTransaction()
	 */
	public LocalTransaction getLocalTransaction() throws ResourceException {
		assertThat("connectionState", connectionState, Is.is(ConnectionState.NEW));
		if (mockTransaction==null){
			mockTransaction=_getLocalTransaction();
		}
		return mockTransaction;
	}

	public MockLocalTransaction _getLocalTransaction() throws ResourceException {
		return new MockLocalTransaction();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#getMetaData()
	 */
	public ConnectionMetaData getMetaData() throws ResourceException {
		assertThat("connectionState", connectionState, Is.is(ConnectionState.NEW));
		if (mockConnectionMetaData==null){
			mockConnectionMetaData=_getMetaData();
		}
		return mockConnectionMetaData;
	}

	public MockConnectionMetaData _getMetaData() throws ResourceException {
		return new MockConnectionMetaData();
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.Connection#getResultSetInfo()
	 */
	public ResultSetInfo getResultSetInfo() throws ResourceException {
		assertThat("connectionState", connectionState, Is.is(ConnectionState.NEW));
		if (mockResultSetInfo==null){
			mockResultSetInfo=_getResultSetInfo();
		}
		return mockResultSetInfo;
	}
	
	public MockResultSetInfo _getResultSetInfo() throws ResourceException {
		return new MockResultSetInfo();
	}
	
	public void validateMockComplete(){
		assertThat("connectionState", connectionState, Is.is(ConnectionState.CLOSE));
		if (mockTransaction!=null){
			mockTransaction.assertMockComplete();			
		}
		if (mockInteraction!=null){
			mockInteraction.validateMockComplete();			
		}		
	}
	
	public void validateMockCommit(){
		assertThat("connectionState", connectionState, Is.is(ConnectionState.CLOSE));
		if (mockTransaction!=null){
			mockTransaction.assertMockCommit();			
		}
		if (mockInteraction!=null){
			mockInteraction.validateMockComplete();			
		}		
	}
	
	public void validateMockRollback(){
		assertThat("connectionState", connectionState, Is.is(ConnectionState.CLOSE));
		if (mockTransaction!=null){
			mockTransaction.validateMockRollback();			
		}
		if (mockInteraction!=null){
			mockInteraction.validateMockComplete();			
		}		
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
