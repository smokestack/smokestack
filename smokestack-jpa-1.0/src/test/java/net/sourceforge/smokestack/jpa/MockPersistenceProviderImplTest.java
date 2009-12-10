package net.sourceforge.smokestack.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class MockPersistenceProviderImplTest {

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

	@Test(expected=PersistenceException.class)
	public final void testCreateEntityManagerFactory() {
		Persistence.createEntityManagerFactory("notdefined", null);
	}

	@Test
	public final void testToString() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hellojpa", null);
		assertThat(emf.toString(), startsWith("net.sourceforge.smokestack.jpa.MockEntityManagerFactory"));
	}

}
