package com.github.smokestack.jca.cci;

import static org.junit.Assert.*;

import javax.resource.ResourceException;
import javax.resource.cci.ResourceAdapterMetaData;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import com.github.smokestack.exception.NeedsMockDefinitionException;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class MockResourceAdapterMetaDataTest {

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

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testGetAdapterName() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.getAdapterName();
	}

	public final void testGetAdapterNameMock() throws ResourceException {
		new Expectations() {
			@Mocked( methods= { "getAdapterName" })
			MockResourceAdapterMetaData mock;
			{
				mock.getAdapterName(); returns("FOO");
			}
		};
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		assertThat(d.getAdapterName(), Is.is("FOO"));
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testGetAdapterShortDescription() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.getAdapterShortDescription();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testGetAdapterVendorName() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.getAdapterVendorName();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testGetAdapterVersion() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.getAdapterVersion();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testGetInteractionSpecsSupported() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.getInteractionSpecsSupported();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testGetSpecVersion() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.getSpecVersion();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testSupportsExecuteWithInputAndOutputRecord() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.supportsExecuteWithInputAndOutputRecord();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testSupportsExecuteWithInputRecordOnly() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.supportsExecuteWithInputRecordOnly();
	}

	@Test(expected=NeedsMockDefinitionException.class)
	public final void testSupportsLocalTransactionDemarcation() throws ResourceException {
		MockConnectionFactory cf = new MockConnectionFactory();
		ResourceAdapterMetaData d=cf.getMetaData();
		d.supportsLocalTransactionDemarcation();
	}
}
