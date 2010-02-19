/**
 * 
 */
package com.github.smokestack.jpa;

import javax.persistence.EntityTransaction;

import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.Matchers;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

/**
 * @author gliptak
 *
 */
public class MockEntityTransaction implements EntityTransaction {

	public enum EntityTransactionState {NEW, BEGIN, COMMIT, ROLLBACK};
	
	protected EntityTransactionState mockState=EntityTransactionState.NEW;
	
	protected boolean isRollbackOnly=false;

	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#begin()
	 */
	public void begin() {
		assertThat("mockState", mockState, IsNot.not(EntityTransactionState.BEGIN));
		_begin();
		mockState=EntityTransactionState.BEGIN;
	}

	public void _begin() {
	}
	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#commit()
	 */
	public void commit() {
		assertThat("mockState", mockState, Is.is(EntityTransactionState.BEGIN));
		assertThat("isRollbackOnly", isRollbackOnly, Is.is(false));
		_commit();
		mockState=EntityTransactionState.COMMIT;
	}

	public void _commit() {
	}
	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#getRollbackOnly()
	 */
	public boolean getRollbackOnly() {
		_getRollbackOnly();
		return isRollbackOnly;
	}

	public boolean _getRollbackOnly() {
		return false;
	}
	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#isActive()
	 */
	public boolean isActive() {
		_isActive();
		return EntityTransactionState.BEGIN==mockState;
	}

	public boolean _isActive() {
		return false;
	}
	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#rollback()
	 */
	public void rollback() {
		assertThat("mockState", mockState, Is.is(EntityTransactionState.BEGIN));
		_rollback();
		mockState=EntityTransactionState.ROLLBACK;
	}

	public void _rollback() {
	}
	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#setRollbackOnly()
	 */
	public void setRollbackOnly() {
		_setRollbackOnly();
		isRollbackOnly=true;
	}

	public void _setRollbackOnly() {
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * Validation
	 */
	public void assertMockComplete() {
		assertThat("mockState", mockState, AnyOf.anyOf(Matchers.equalTo(EntityTransactionState.COMMIT), Matchers.equalTo(EntityTransactionState.ROLLBACK)));	
	}
	
	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertThat("mockState", mockState, Is.is(EntityTransactionState.COMMIT));
	}
	
	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertThat("mockState", mockState, Is.is(EntityTransactionState.ROLLBACK));
	}

	public EntityTransactionState getMockState() {
		return mockState;
	}
}
