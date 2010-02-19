package com.github.smokestack.jca.cci;

import javax.resource.ResourceException;
import javax.resource.cci.LocalTransaction;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.Matchers;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;

import static org.hamcrest.MatcherAssert.assertThat;

public class MockLocalTransaction implements LocalTransaction {
	
	public enum LocalTransactionState {NEW, BEGIN, COMMIT, ROLLBACK};
	
	protected LocalTransactionState localTransactionState=LocalTransactionState.NEW;

	public MockLocalTransaction(){
	}
	
	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#begin()
	 */
	public void begin() throws ResourceException {
		assertThat("localTransactionState", localTransactionState, Is.is(LocalTransactionState.NEW));
		_begin();
		localTransactionState=LocalTransactionState.BEGIN;
	}

	public void _begin() throws ResourceException {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#commit()
	 */
	public void commit() throws ResourceException {
		assertThat("localTransactionState", localTransactionState, Is.is(LocalTransactionState.BEGIN));
		_commit();
		localTransactionState=LocalTransactionState.COMMIT;
	}

	public void _commit() throws ResourceException {
	}

	/* (non-Javadoc)
	 * @see javax.resource.cci.LocalTransaction#rollback()
	 */
	public void rollback() throws ResourceException {
		assertThat("localTransactionState", localTransactionState, Is.is(LocalTransactionState.BEGIN));
		_rollback();
		localTransactionState=LocalTransactionState.ROLLBACK;
	}

	public void _rollback() throws ResourceException {
	}

	public LocalTransactionState getMockTransactionState() {
		_getMockTransactionState();
		return localTransactionState;
	}

	public LocalTransactionState _getMockTransactionState() {
		return null;
	}

	public void assertMockComplete(){
		assertThat("localTransactionState", localTransactionState, AnyOf.anyOf(Matchers.equalTo(LocalTransactionState.COMMIT), Matchers.equalTo(LocalTransactionState.ROLLBACK)));	
	}
	
	public void assertMockCommit(){
		assertThat("localTransactionState", localTransactionState, Is.is(LocalTransactionState.COMMIT));	
	}

	public void validateMockRollback(){
		assertThat("localTransactionState", localTransactionState, Is.is(LocalTransactionState.ROLLBACK));	
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
