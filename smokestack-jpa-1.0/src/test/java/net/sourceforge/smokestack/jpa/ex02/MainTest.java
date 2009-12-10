package net.sourceforge.smokestack.jpa.ex02;


import static net.sourceforge.smokestack.jpa.ex02.Deity.Gender.FEMALE;
import static net.sourceforge.smokestack.jpa.ex02.Deity.Gender.MALE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mock;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import net.sourceforge.smokestack.jpa.MockBaseQuery;
import net.sourceforge.smokestack.jpa.MockEntityManager;
import net.sourceforge.smokestack.jpa.MockEntityManagerFactory;
import net.sourceforge.smokestack.jpa.MockPersistenceProviderImpl;
import net.sourceforge.smokestack.jpa.MockQLQuery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
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
			@Mocked( methods= {"executeUpdate", "getResultList"})
			MockBaseQuery q;
			@Mocked (methods= {"persist", "getReference"})
			MockEntityManager em;
			{
				q.executeUpdate(); returns(1);
                em.persist(any);
                List<Deity> l=new ArrayList<Deity>();
		        l.add(new Deity("Uranus", MALE));
		        l.add(new Deity("Gaea", FEMALE));
                q.getResultList(); returns(l);
                List<Deity> l1=new ArrayList<Deity>();
                l1.add(new Deity("Apollo", MALE));
                l1.add(new Deity("Artemis", MALE));
                q.getResultList(); returns(l1);
                Deity rhea = new Deity("Rhea", FEMALE);
                em.getReference(Deity.class, "Rhea"); returns(rhea);
                em.getReference(Deity.class, "Rhea"); returns(rhea);
                List<Deity> l2=new ArrayList<Deity>();
                l2.add(new Deity("Coeus", MALE));
                l2.add(new Deity("Phoebe", FEMALE));
                q.getResultList(); returns(l2);
                Deity apollo=new Deity("Apollo", MALE);
                em.getReference(Deity.class, "Apollo"); returns(apollo);
                List<Deity> l3=new ArrayList<Deity>();
                l3.add(new Deity("Ares", MALE));
                l3.add(new Deity("Hebe", FEMALE));
                q.getResultList(); returns(l3);
                Deity leto=new Deity("Leto", FEMALE);
                em.getReference(Deity.class, "Leto"); returns(leto);
                List<Deity> l4=new ArrayList<Deity>();
                l4.add(new Deity("Pluto", MALE));
                l4.add(new Deity("Hestia", FEMALE));
                q.getResultList(); returns(l4);
			}
		};
		String[] args=new String[0];
		Main.main(args);
		
		// there is no easy way to get to the EntityManager ...
		Set<PersistenceProvider> providers=(Set<PersistenceProvider>)Deencapsulation.getField(Persistence.class, "providers");
		Object[] pa=providers.toArray();
		MockEntityManagerFactory f=((MockPersistenceProviderImpl)(pa[0])).getMockEntityManagerFactories().get("relations");
		
		// the actual validation
		f.assertMockComplete();
	}
}
