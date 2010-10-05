package com.github.smokestack.jpa.ex01;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;
import com.github.smokestack.jpa.MockBaseQuery;
import com.github.smokestack.jpa.MockEntityManager;
import com.github.smokestack.jpa.MockEntityManagerFactory;
import com.github.smokestack.jpa.MockPersistenceProviderImpl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

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
	public void testMain(){
		new Expectations() {
			@Mocked( methods= { "persist" })
			MockEntityManager mockEM;
			@Mocked( methods= {"getResultList"})
			MockBaseQuery mockQuery;
			{
				mockEM.persist(any);
				List<Message> l=new ArrayList<Message>();
				l.add(new Message("Hello Persistence!"));
				mockQuery.getResultList(); returns(l);
			}
		};
		String[] args=new String[0];
		Main.main(args);
		
		// there is no easy way to get to the EntityManager ...
		Set<PersistenceProvider> providers=(Set<PersistenceProvider>)Deencapsulation.getField(Persistence.class, "providers");
		Object[] pa=providers.toArray();
		MockEntityManagerFactory f=((MockPersistenceProviderImpl)(pa[0])).getMockEntityManagerFactories().get("hellojpa");
		
		// the actual validation
		f.assertMockComplete();
	}
}
