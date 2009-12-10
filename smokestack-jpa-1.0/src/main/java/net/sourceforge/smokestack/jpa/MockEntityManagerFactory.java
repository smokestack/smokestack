/**
 * 
 */
package net.sourceforge.smokestack.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hamcrest.core.Is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author gliptak
 *
 */
public class MockEntityManagerFactory implements EntityManagerFactory {

	public enum EMFactoryState {NEW, CLOSE};

	protected EMFactoryState mockState=EMFactoryState.NEW;
	
	protected List<MockEntityManager> mockEntityManagers=new ArrayList<MockEntityManager>();
	
	/**
	 * Constructor
	 */
	public MockEntityManagerFactory() {
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManagerFactory#close()
	 */
	public void close() {
		assertThat("mockState", mockState, Is.is(EMFactoryState.NEW));
		mockState=EMFactoryState.CLOSE;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManagerFactory#createEntityManager()
	 */
	public EntityManager createEntityManager() {
		assertThat("mockState", mockState, Is.is(EMFactoryState.NEW));
		MockEntityManager em=new MockEntityManager();
		mockEntityManagers.add(em);
		return em;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManagerFactory#createEntityManager(java.util.Map)
	 */
	public EntityManager createEntityManager(Map map) {
		assertThat("mockState", mockState, Is.is(EMFactoryState.NEW));
		MockEntityManager em=new MockEntityManager(map);
		mockEntityManagers.add(em);
		return em;
	}

	/* (non-Javadoc)
	 * @see javax.persistence.EntityManagerFactory#isOpen()
	 */
	public boolean isOpen() {
		return EMFactoryState.NEW==mockState;
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
		assertThat("mockState", mockState, Is.is(EMFactoryState.CLOSE));
		for (MockEntityManager em: mockEntityManagers){
			em.assertMockComplete();	
		}
	}

	/**
	 * Validation
	 */
	public void assertMockCommit() {
		assertThat("mockState", mockState, Is.is(EMFactoryState.CLOSE));
		for (MockEntityManager em: mockEntityManagers){
			em.assertMockCommit();	
		}
	}

	/**
	 * Validation
	 */
	public void assertMockRollback() {
		assertThat("mockState", mockState, Is.is(EMFactoryState.CLOSE));
		for (MockEntityManager em: mockEntityManagers){
			em.assertMockRollback();	
		}
	}

	public EMFactoryState getMockState() {
		return mockState;
	}
}
