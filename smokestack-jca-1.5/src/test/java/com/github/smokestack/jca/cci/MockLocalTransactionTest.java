package com.github.smokestack.jca.cci;

import static org.junit.Assert.*;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.LocalTransaction;

import com.github.smokestack.jca.cci.MockLocalTransaction.LocalTransactionState;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockLocalTransactionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testBegin() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		Connection c=cf.getConnection();
		LocalTransaction t=c.getLocalTransaction();
		t.begin();
		t.commit();
		assertThat(((MockLocalTransaction)t).getMockTransactionState(), Is.is(LocalTransactionState.COMMIT));
	}

	@Test (expected=AssertionError.class)
	public final void testBeginDouble() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		Connection c=cf.getConnection();
		LocalTransaction t=c.getLocalTransaction();
		t.begin();
		t.begin();
	}

	@Test
	public final void testRollback() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		Connection c=cf.getConnection();
		LocalTransaction t=c.getLocalTransaction();
		t.begin();
		t.rollback();
		assertThat(((MockLocalTransaction)t).getMockTransactionState(), Is.is(LocalTransactionState.ROLLBACK));
	}

}
