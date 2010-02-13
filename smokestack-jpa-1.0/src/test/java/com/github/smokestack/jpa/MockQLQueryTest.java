package com.github.smokestack.jpa;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Map;

import javax.persistence.TemporalType;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MockQLQueryTest {

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
	public final void testParsing1() {
		String ql="SELECT ps FROM XMLPropertySub ps "+
		     "WHERE ps.id = :id AND ps.name = :name AND ps.createDate = :crtDate";
		MockQLQuery q=new MockQLQuery(ql);
		q.setParameter("id", "id1");
		q.setParameter("name", "name2");
		q.setParameter("crtDate", new Date(), TemporalType.DATE);
		try {
			q.setParameter("noSuchField", "value");
			fail("expected AssertionError");
		} catch (AssertionError ae){
			// IGNORE
		}
		Map<String, Object> m=q.getMockParameters();
		assertThat((String)m.get("name"), Is.is("name2"));
	}
	
	@Test(expected=AssertionError.class)
	public final void testNull() {
		MockQLQuery q=new MockQLQuery(null);
	}
}
