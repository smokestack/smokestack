package com.github.smokestack.ejb.internal;

import java.util.List;
import java.util.Vector;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.Is;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClassFinderTest {

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
	public final void testFindSubclasses() {
		String className="com.github.smokestack.ejb.ex03.DataStoreLocal";
		ClassFinder finder = new ClassFinder();
		Vector<Class<?>> v = finder.findSubclasses(className);
		List<Throwable> errors = finder.getErrors();

		assertThat(v.size(), Is.is(1));
//		assertThat((Class)v.get(0), equalTo(DataStoreImpl.class));
	}

}
