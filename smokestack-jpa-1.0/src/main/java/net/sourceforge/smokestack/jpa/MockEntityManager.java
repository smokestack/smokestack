/**
 * 
 */
package net.sourceforge.smokestack.jpa;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.Is;

import net.sourceforge.smokestack.exception.NeedsMockDefinitionException;
import net.sourceforge.smokestack.exception.NotYetImplementedException;
import net.sourceforge.smokestack.jpa.MockEntityTransaction.EntityTransactionState;

/**
 * @author gliptak
 *
 */
public class MockEntityManager implements EntityManager {

	protected Map map=new HashMap();

	protected FlushModeType flushModeType;
	
	protected MockEntityTransaction mockEntityTransaction;

	public enum EntityManagerState {NEW, CLOSE};
	
	protected EntityManagerState mockState=EntityManagerState.NEW;

	/**
	 * Constructor
	 */
	public MockEntityManager() {
	}

	/**
	 * Constructor
	 */
	public MockEntityManager(Map map){
		this.map=map;
	}
	
	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#clear()
	 */
	public void clear() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#close()
	 */
	public void close() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		mockState=EntityManagerState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#contains(java.lang.Object)
	 */
	public boolean contains(Object entity) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNamedQuery(java.lang.String)
	 */
	public Query createNamedQuery(String name) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		return new MockNamedQuery(name);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNativeQuery(java.lang.String)
	 */
	public Query createNativeQuery(String sqlString) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		return new MockNativeQuery(sqlString);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNativeQuery(java.lang.String, java.lang.Class)
	 */
	public Query createNativeQuery(String sqlString, Class resultClass) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		return new MockNativeQuery(sqlString, resultClass);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createNativeQuery(java.lang.String, java.lang.String)
	 */
	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		return new MockNativeQuery(sqlString, resultSetMapping);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#createQuery(java.lang.String)
	 */
	public Query createQuery(String qlString) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		return new MockQLQuery(qlString);
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#find(java.lang.Class, java.lang.Object)
	 */
	public <T> T find(Class<T> arg0, Object arg1) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#flush()
	 */
	public void flush() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getDelegate()
	 */
	public Object getDelegate() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getFlushMode()
	 */
	public FlushModeType getFlushMode() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		return flushModeType;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getReference(java.lang.Class, java.lang.Object)
	 */
	public <T> T getReference(Class<T> arg0, Object arg1) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#getTransaction()
	 */
	public EntityTransaction getTransaction() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		if (mockEntityTransaction==null){
			mockEntityTransaction=new MockEntityTransaction();
		}
		return mockEntityTransaction;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#isOpen()
	 */
	public boolean isOpen() {
		return EntityManagerState.NEW==mockState;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#joinTransaction()
	 */
	public void joinTransaction() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#lock(java.lang.Object, javax.persistence.LockModeType)
	 */
	public void lock(Object arg0, LockModeType arg1) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NotYetImplementedException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#merge(java.lang.Object)
	 */
	public <T> T merge(T arg0) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#persist(java.lang.Object)
	 */
	public void persist(Object arg0) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#refresh(java.lang.Object)
	 */
	public void refresh(Object arg0) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#remove(java.lang.Object)
	 */
	public void remove(Object arg0) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		throw new NeedsMockDefinitionException();
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManager#setFlushMode(javax.persistence.FlushModeType)
	 */
	public void setFlushMode(FlushModeType flushModeType) {
		assertThat("mockState", mockState, Is.is(EntityManagerState.NEW));
		this.flushModeType=flushModeType;
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
		assertThat("mockState", mockState, Is.is(EntityManagerState.CLOSE));
		if (mockEntityTransaction!=null){
			mockEntityTransaction.assertMockComplete();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.CLOSE));
		if (mockEntityTransaction!=null){
			mockEntityTransaction.assertMockCommit();
		}
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertThat("mockState", mockState, Is.is(EntityManagerState.CLOSE));
		if (mockEntityTransaction!=null){
			mockEntityTransaction.assertMockRollback();
		}
	}

	public EntityManagerState getMockState() {
		return mockState;
	}

	public MockEntityTransaction getMockEntityTransaction() {
		return mockEntityTransaction;
	}
}
