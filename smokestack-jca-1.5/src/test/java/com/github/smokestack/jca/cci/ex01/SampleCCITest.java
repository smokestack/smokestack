package com.github.smokestack.jca.cci.ex01;

import static org.junit.Assert.*;

import javax.naming.InitialContext;
import javax.resource.cci.InteractionSpec;
import javax.resource.cci.Record;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

import com.github.smokestack.jca.cci.MockConnectionFactory;
import com.github.smokestack.jca.cci.MockInteraction;

import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class SampleCCITest {

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
	public void testSuccess() throws Exception {
		InitialContext ic = new InitialContext();
		MockConnectionFactory cf = new MockConnectionFactory();
		ic.bind("java:comp/env/eis/myConnection", cf);

		new Expectations() {
			@Mocked( methods= { "execute" })
			MockInteraction mock;
			{
				Record outRec = new SampleRecord();
				outRec.setRecordName("BAR");
				outRec.setRecordShortDescription("bar");
				mock.execute((InteractionSpec)null, (Record)with(HasPropertyWithValue.<Record>hasProperty("recordName", IsEqual.equalTo("FOO"))));
				returns(outRec);
			}
		};

		SampleCCI cci = new SampleCCI();
		Record inRec = new SampleRecord();
		inRec.setRecordName("FOO");
		inRec.setRecordShortDescription("foo");
		Record outRec = cci.execute(inRec);
		assertThat(outRec.getRecordName(), Is.is("BAR"));
		cf.validateMockCommit();
		ic.close();
	}

	@Test(expected=AssertionError.class)
	public void testMismatch() throws Exception {
		InitialContext ic = new InitialContext();
		MockConnectionFactory cf = new MockConnectionFactory();
		ic.bind("java:comp/env/eis/myConnection", cf);

		new Expectations() {
			@Mocked( methods= { "execute" })
			MockInteraction mock;
			{
				Record outRec = new SampleRecord();
				outRec.setRecordName("BAR");
				outRec.setRecordShortDescription("bar");
				mock.execute((InteractionSpec)null, (Record)with(HasPropertyWithValue.<Record>hasProperty("recordName", IsEqual.equalTo("FOO1"))));
				returns(outRec);
			}
		};

		SampleCCI cci = new SampleCCI();
		Record inRec = new SampleRecord();
		inRec.setRecordName("FOO");
		inRec.setRecordShortDescription("foo");
		Record outRec = cci.execute(inRec);
		assertThat(outRec.getRecordName(), Is.is("BAR"));
		cf.validateMockCommit();
		ic.close();
	}

	@Test
	public void testDouble() throws Exception {
		InitialContext ic = new InitialContext();
		MockConnectionFactory cf = new MockConnectionFactory();
		ic.bind("java:comp/env/eis/myConnection", cf);

		new Expectations() {
			@Mocked( methods= { "execute" })
			MockInteraction mock;
			{
				Record outRec = new SampleRecord();
				outRec.setRecordName("BAR");
				outRec.setRecordShortDescription("bar");
				mock.execute((InteractionSpec)null, (Record)with(HasPropertyWithValue.<Record>hasProperty("recordName", IsEqual.equalTo("FOO"))));
				returns(outRec);
				Record outRec1 = new SampleRecord();
				outRec1.setRecordName("BAR1");
				outRec1.setRecordShortDescription("bar");
				mock.execute((InteractionSpec)null, (Record)with(HasPropertyWithValue.<Record>hasProperty("recordName", IsEqual.equalTo("FOO1"))));
				returns(outRec1);
			}
		};

		SampleCCI cci = new SampleCCI();
		Record inRec = new SampleRecord();
		inRec.setRecordName("FOO");
		inRec.setRecordShortDescription("foo");
		Record outRec = cci.execute(inRec);
		assertThat(outRec.getRecordName(), Is.is("BAR"));
		Record inRec1 = new SampleRecord();
		inRec1.setRecordName("FOO1");
		inRec1.setRecordShortDescription("foo1");
		Record outRec1 = cci.execute(inRec1);
		assertThat(outRec1.getRecordName(), Is.is("BAR1"));

		cf.validateMockCommit();
		ic.close();
	}
}
