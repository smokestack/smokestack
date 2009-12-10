/**
 * 
 */
package net.sourceforge.smokestack.jpa;

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
		mockState=EntityTransactionState.BEGIN;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#commit()
	 */
	public void commit() {
		assertThat("mockState", mockState, Is.is(EntityTransactionState.BEGIN));
		assertThat("isRollbackOnly", isRollbackOnly, Is.is(false));
		mockState=EntityTransactionState.COMMIT;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#getRollbackOnly()
	 */
	public boolean getRollbackOnly() {
		return isRollbackOnly;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#isActive()
	 */
	public boolean isActive() {
		return EntityTransactionState.BEGIN==mockState;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#rollback()
	 */
	public void rollback() {
		assertThat("mockState", mockState, Is.is(EntityTransactionState.BEGIN));
		mockState=EntityTransactionState.ROLLBACK;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityTransaction#setRollbackOnly()
	 */
	public void setRollbackOnly() {
		isRollbackOnly=true;
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
